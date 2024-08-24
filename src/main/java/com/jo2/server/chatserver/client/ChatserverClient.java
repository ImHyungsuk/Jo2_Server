package com.jo2.server.chatserver.client;

import com.jo2.server.chatserver.client.dto.ChatserverAnalysisRequest;
import com.jo2.server.chatserver.dto.response.ChatserverAnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "chatserverClient",url = "http://3.34.120.240:5000/api/chatbot")
public interface ChatserverClient {

    @PostMapping(value = "/start")
    @Headers("Content-Type: application/json")
    ChatserverStartResponse startServer(
            @RequestParam("user_id") Long memberId
    );

    @PostMapping(value = "/analyze")
    @Headers("Content-Type: application/json")
    ChatserverAnalysisResponse analysis(
            @RequestBody ChatserverAnalysisRequest chatserverAnalysisRequest
            );

}
