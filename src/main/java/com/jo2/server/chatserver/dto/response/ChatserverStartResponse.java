package com.jo2.server.chatserver.dto.response;


public record ChatserverStartResponse(
        Long memberId,
        String message
) {
}
