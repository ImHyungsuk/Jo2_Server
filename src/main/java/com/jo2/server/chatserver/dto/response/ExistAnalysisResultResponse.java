package com.jo2.server.chatserver.dto.response;

import com.jo2.server.analysis.entity.Analysis;

public record ExistAnalysisResultResponse(
        String result,
        Analysis analysis
) implements AnalysisResultResponse {
    public static ExistAnalysisResultResponse from(Analysis analysis){
        return new ExistAnalysisResultResponse(analysis.getResult(),analysis);
    }
}
