package com.jo2.server.chatserver.service;

import com.jo2.server.analysis.adapter.AnalysisFinder;
import com.jo2.server.analysis.adapter.AnalysisSaver;
import com.jo2.server.analysis.dto.AnalysisResponse;
import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.chatserver.client.ChatserverClient;
import com.jo2.server.chatserver.client.dto.ChatserverAnalysisRequest;
import com.jo2.server.chatserver.dto.request.ChatServerStartRequest;
import com.jo2.server.chatserver.dto.response.ChatserverAnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import com.jo2.server.member.adapter.MemberFinder;
import com.jo2.server.member.entity.Member;
import com.jo2.server.weather.adapter.WeatherFinder;
import com.jo2.server.weather.entity.Weather;
import com.jo2.server.weather.entity.WeatherList;
import com.jo2.server.weather.exception.WeatherException;
import com.jo2.server.weather.message.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatserverService {

    private final ChatserverClient chatserverClient;
    private final MemberFinder memberFinder;
    private final WeatherFinder weatherFinder;
    private final AnalysisFinder analysisFinder;
    private final AnalysisSaver analysisSaver;

    public ChatserverStartResponse startChatserver(Long memberId) {
        return chatserverClient.startServer(ChatServerStartRequest.from(memberId.intValue()));
    }

    @Transactional
    public AnalysisResponse getAnalysis(long memberId) {
        Optional<Member> member = memberFinder.findById(memberId);
        WeatherList weatherList = weatherFinder.findAllById(memberId);
        Optional<Analysis> optionalAnalysis = analysisFinder.findAnalysisByMemberId(memberId);
        AnalysisResponse response;
        Long recentweatherId;

        try {
            recentweatherId = weatherFinder.findTopByMemberIdOrderByCreatedAtDesc(memberId).get().getId();
        } catch (Exception e){
            log.info(String.valueOf(e));
            throw new WeatherException(ErrorCode.NO_WEATHER_EXCEPTION);
        }

        if (optionalAnalysis.isPresent()) {
            Analysis analysis = optionalAnalysis.get();
            if (analysis.getWeatherId() != recentweatherId) {
                String result = requestAnalysis(memberId,weatherList);
                analysis.updateResult(result,recentweatherId);
            }
        } else {
            String result = requestAnalysis(memberId,weatherList);
            analysisSaver.createAnalysis(member.get(),recentweatherId, result);
        }
        Analysis analysis = analysisFinder.findAnalysisByMemberId(memberId).get();
        response = AnalysisResponse.from(analysis.getResult());
        return response;
    }

    private String requestAnalysis(long memberId, WeatherList weatherList){
        ChatserverAnalysisResponse analysisResponse = chatserverClient.analysis(
                ChatserverAnalysisRequest.of(memberId, weatherList));
        return analysisResponse.result();
    }
}
