package com.jo2.server.chatserver.service;

import com.jo2.server.analysis.adapter.AnalysisFinder;
import com.jo2.server.analysis.adapter.AnalysisSaver;
import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.chatserver.client.ChatserverClient;
import com.jo2.server.chatserver.client.dto.ChatserverAnalysisRequest;
import com.jo2.server.chatserver.dto.response.ChatserverAnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import com.jo2.server.member.adapter.MemberFinder;
import com.jo2.server.member.entity.Member;
import com.jo2.server.weather.adapter.WeatherFinder;
import com.jo2.server.weather.entity.WeatherList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatserverService {

    private final ChatserverClient chatserverClient;
    private final MemberFinder memberFinder;
    private final WeatherFinder weatherFinder;
    private final AnalysisFinder analysisFinder;
    private final AnalysisSaver analysisSaver;

    public ChatserverStartResponse startChatserver(long memberId) {
        return chatserverClient.startServer(memberId);
    }

    @Transactional
    public ChatserverAnalysisResponse requestAnalysis(long memberId) {
        WeatherList weatherList = weatherFinder.findAllById(memberId);
        long weatherId = weatherFinder.findTopByMemberIdOrderByCreatedAtDesc(memberId).get().getId();
        Optional<Member> member = memberFinder.findById(memberId);
        Optional<Analysis> optionalAnalysis = analysisFinder.findAnalysis(memberId);

        ChatserverAnalysisResponse response = chatserverClient.analysis(
                ChatserverAnalysisRequest.of(memberId, weatherList));

        if (optionalAnalysis.isPresent()) {
            Analysis analysis = optionalAnalysis.get();
            analysis.updateResult(response.result(), weatherId);
        } else {
            analysisSaver.createAnalysis(member.get(), weatherId, response.result());
        }
        return response;
    }
}
