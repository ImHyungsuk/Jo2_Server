package com.jo2.server.chatserver.service;

import com.jo2.server.analysis.adapter.AnalysisFinder;
import com.jo2.server.analysis.adapter.AnalysisSaver;
import com.jo2.server.analysis.dto.response.AnalysisResponse;
import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.chatserver.client.AnalysisRequester;
import com.jo2.server.chatserver.dto.response.AnalysisResultResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import com.jo2.server.chatserver.dto.response.ExistAnalysisResultResponse;
import com.jo2.server.chatserver.dto.response.NewAnalysisResultResponse;
import com.jo2.server.chatserver.exception.ChatserverException;
import com.jo2.server.chatserver.message.ErrorCode;
import com.jo2.server.member.adapter.MemberFinder;
import com.jo2.server.member.entity.Member;
import com.jo2.server.weather.adapter.WeatherFinder;
import com.jo2.server.weather.vo.WeatherVO;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatServerService {

    private final AnalysisRequester analysisRequester;
    private final MemberFinder memberFinder;
    private final WeatherFinder weatherFinder;
    private final AnalysisSaver analysisSaver;
    private final AnalysisFinder analysisFinder;

    public ChatserverStartResponse startChatServer(Long memberId) {
        return analysisRequester.startChatServer(memberId);
    }

    @Transactional
    public AnalysisResponse getAnalysis(long memberId) {
        AnalysisResultResponse requestResult = getResult(memberId);
        String analysisResult = createOrUpdateAnalysis(requestResult, memberId);
        return AnalysisResponse.from(analysisResult);
    }

    private AnalysisResultResponse getResult(long memberId) {
        List<WeatherVO> weatherVOList = weatherFinder.findAllById(memberId);
        Optional<Analysis> optionalAnalysis = analysisFinder.findAnalysisByMemberId(memberId);
        return analysisRequester.requestAnalysis(weatherVOList,optionalAnalysis);
    }

    private String createOrUpdateAnalysis(AnalysisResultResponse result, long memberId) {
        Member member = memberFinder.findById(memberId);
        Analysis analysis;
        if(result instanceof NewAnalysisResultResponse resultResponse){
            analysis = Analysis.of(member, resultResponse.result());
            analysisSaver.createAnalysis(analysis);
            return analysis.getResult();
        }
        if(result instanceof ExistAnalysisResultResponse resultResponse){
            analysis = resultResponse.analysis();
            analysis.updateResult(resultResponse.result());
            return analysis.getResult();
        }
        throw new ChatserverException(ErrorCode.INVALID_DATA_TYPE);
    }
}
