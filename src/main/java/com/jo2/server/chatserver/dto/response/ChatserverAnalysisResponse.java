package com.jo2.server.chatserver.dto.response;

public record ChatserverAnalysisResponse(
        String result
) {
    public static ChatserverAnalysisResponse from(String result) {
        return new ChatserverAnalysisResponse(result);
    }
}
