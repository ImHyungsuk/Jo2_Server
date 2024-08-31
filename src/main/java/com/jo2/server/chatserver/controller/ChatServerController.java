package com.jo2.server.chatserver.controller;

import static com.jo2.server.chatserver.message.SuccessMessage.SUCCESS_ANALYSIS;
import static com.jo2.server.common.dto.SuccessResponse.success;
import static com.jo2.server.chatserver.message.SuccessMessage.SUCCESS_START_CHATTING;

import com.jo2.server.analysis.dto.response.AnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import com.jo2.server.chatserver.service.ChatServerService;
import com.jo2.server.common.dto.SuccessResponse;
import com.jo2.server.common.resolver.member.MemberId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat-server")
public class ChatServerController {

    private final ChatServerService chatServerService;

    @PostMapping
    public ResponseEntity<SuccessResponse<ChatserverStartResponse>> startChatting(@MemberId final Long memberId) {;
        ChatserverStartResponse response = chatServerService.startChatServer(memberId);
        return ResponseEntity.ok().body(success(SUCCESS_START_CHATTING.getMessage(), response));
    }

    @GetMapping("/analysis")
    public ResponseEntity<SuccessResponse<AnalysisResponse>>analysis(@MemberId final Long memberId){
        AnalysisResponse response = chatServerService.getAnalysis(memberId);
        return ResponseEntity.ok().body(success(SUCCESS_ANALYSIS.getMessage(), response));
    }
}
