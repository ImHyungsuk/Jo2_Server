package com.jo2.server.chatserver.client;

import com.jo2.server.chatserver.client.dto.ChatServerAnalysisRequest;
import com.jo2.server.chatserver.dto.request.ChatServerStartRequest;
import com.jo2.server.chatserver.dto.response.ChatserverAnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "chatserverClient",url = "http://3.34.120.240:5000/api/chatbot")
public interface ChatserverClient {

    @PostMapping(value = "/start", consumes = "application/json")
    ChatserverStartResponse startServer(
            @RequestBody ChatServerStartRequest memberId
    );

    @PostMapping(value = "/analyze", consumes = "application/json")
    ChatserverAnalysisResponse analysis(
            @RequestBody ChatServerAnalysisRequest chatserverAnalysisRequest
            );

}
