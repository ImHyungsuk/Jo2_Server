package com.jo2.server.chatserver.dto.response;

public record ChatServerAnalysisResponse(
        String result
) {
    public static ChatServerAnalysisResponse from(String result) {
        return new ChatServerAnalysisResponse(result);
    }
}
