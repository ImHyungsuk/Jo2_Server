package com.jo2.server.chatserver.client;

import com.jo2.server.chatserver.dto.response.ChatserverAnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "chatserverClient",url = "http://localhost:5000/chatbot")
public interface ChatserverClient {

    @PostMapping(value = "/start")
    ChatserverStartResponse startServer(
            @RequestParam("user_id") Long memberId
    );

    @PostMapping(value = "/analyze")
    ChatserverAnalysisResponse analysis(
            @RequestParam("user_id") Long memberId,
            @RequestParam("summaries") List<String> summaries
    );
}
