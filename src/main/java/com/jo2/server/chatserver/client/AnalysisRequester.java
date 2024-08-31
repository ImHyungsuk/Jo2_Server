package com.jo2.server.chatserver.client;

import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.chatserver.client.dto.ChatServerAnalysisRequest;
import com.jo2.server.chatserver.dto.request.ChatServerStartRequest;
import com.jo2.server.chatserver.dto.response.AnalysisResultResponse;
import com.jo2.server.chatserver.dto.response.ChatServerAnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import com.jo2.server.chatserver.dto.response.ExistAnalysisResultResponse;
import com.jo2.server.chatserver.dto.response.NewAnalysisResultResponse;
import com.jo2.server.chatserver.exception.ChatserverException;
import com.jo2.server.chatserver.message.ErrorCode;
import com.jo2.server.weather.vo.WeatherVO;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AnalysisRequester {

    private final ChatServerClient chatServerClient;

    public ChatserverStartResponse startChatServer(Long memberId) {
        return chatServerClient.startServer(ChatServerStartRequest.from(memberId.intValue()));
    }

    public AnalysisResultResponse requestAnalysis(List<WeatherVO> weatherVOList, Optional<Analysis> optionalAnalysis) {
        if (optionalAnalysis.isEmpty()) {
            checkBeforeRequest(weatherVOList);
        } else {
            Analysis analysis = optionalAnalysis.get();
            if (ChronoUnit.DAYS.between(LocalDate.now(), analysis.toLoCalDate()) < 7) {
                return ExistAnalysisResultResponse.from(analysis);
            }
        }
        ChatServerAnalysisResponse analysisResponse = requestAnalysis(weatherVOList);
        return NewAnalysisResultResponse.from(analysisResponse.result());
    }

    private void checkBeforeRequest(List<WeatherVO> weatherVOList) {
        if (weatherVOList.isEmpty()) {
            throw new ChatserverException(ErrorCode.NONE_EXIST_DATA);
        }
    }

    private ChatServerAnalysisResponse requestAnalysis(List<WeatherVO> weatherVOList) {
        return chatServerClient.analysis(ChatServerAnalysisRequest.from(weatherVOList));
    }
}