package com.jo2.server.chatserver.dto.request;

public record ChatServerStartRequest(
        int user_id
) {
    public static ChatServerStartRequest from(int user_id){
        return new ChatServerStartRequest(user_id);
    }
}