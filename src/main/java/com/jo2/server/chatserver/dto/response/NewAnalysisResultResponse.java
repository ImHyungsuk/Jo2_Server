package com.jo2.server.chatserver.dto.response;

public record NewAnalysisResultResponse(
    String result
) implements AnalysisResultResponse{
    public static NewAnalysisResultResponse from(String result){
        return new NewAnalysisResultResponse(result);
    }
}
