package com.jo2.server.chatserver.service;

import com.jo2.server.analysis.adapter.AnalysisSaver;
import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.chatserver.client.ChatserverClient;
import com.jo2.server.chatserver.dto.response.ChatserverAnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import com.jo2.server.member.adapter.MemberFinder;
import com.jo2.server.member.entity.Member;
import com.jo2.server.weather.adapter.WeatherFinder;
import com.jo2.server.weather.entity.Weather;
import com.jo2.server.weather.entity.WeatherList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatserverService {

    private final ChatserverClient chatserverClient;
    private final MemberFinder memberFinder;
    private final WeatherFinder weatherFinder;
    private final AnalysisSaver analysisSaver;

    public ChatserverStartResponse startChatserver(long memberId) {
        ChatserverStartResponse response = chatserverClient.startServer(memberId);
        return response;
    }

    public ChatserverAnalysisResponse requestAnalysis(long memberId) {
        LocalDate now = LocalDate.now();
        LocalDate start = now.minusDays(30);
        List<String> summaries = weatherFinder.findByMemberIdAndDateBetween(memberId, start, now);
        ChatserverAnalysisResponse response = chatserverClient.analysis(memberId, summaries);
        long weatherId = weatherFinder.findTopByMemberIdOrderByCreatedAtDesc(memberId).get().getId();
        Optional<Member> member = memberFinder.findById(memberId);
        analysisSaver.save(createAnalysis(member.get(), response.result(), weatherId));

        return response;
    }

    private Analysis createAnalysis(Member member, String result, long weatherId) {
        return Analysis.of(member, weatherId, result);
    }
}
