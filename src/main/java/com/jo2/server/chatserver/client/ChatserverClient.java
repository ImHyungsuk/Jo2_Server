package com.jo2.server.chatserver.client;

import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "chatserverClient",url = "http://localhost:5000/chatbot")
public interface ChatserverClient {

    @PostMapping(value = "/start")
    ChatserverStartResponse startServer(
            @RequestParam("user_id") Long memberId
    );
}
