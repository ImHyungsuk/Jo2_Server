package com.jo2.server.chatserver.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ChatServerStartRequest(
        int userId
) {
    public static ChatServerStartRequest from(int user_id){
        return new ChatServerStartRequest(user_id);
    }
}