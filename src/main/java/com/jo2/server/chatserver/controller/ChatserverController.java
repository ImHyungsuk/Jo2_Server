package com.jo2.server.chatserver.controller;

import static com.jo2.server.chatserver.message.SuccessMessage.SUCCESS_ANALYSIS;
import static com.jo2.server.common.dto.SuccessResponse.success;
import static com.jo2.server.chatserver.message.SuccessMessage.SUCCESS_START_CHATTING;

import com.jo2.server.analysis.dto.AnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverAnalysisResponse;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import com.jo2.server.chatserver.service.ChatserverService;
import com.jo2.server.common.dto.SuccessResponse;
import com.jo2.server.common.resolver.member.MemberId;
import com.jo2.server.member.entity.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat-server")
public class ChatserverController {

    private final ChatserverService chatserverService;

    @PostMapping
    public ResponseEntity<SuccessResponse<ChatserverStartResponse>> startChatting(@MemberId final Long memberId) {;
        ChatserverStartResponse response = chatserverService.startChatserver(memberId);
        return ResponseEntity.ok().body(success(SUCCESS_START_CHATTING.getMessage(), response));
    }

    @GetMapping("/analysis")
    public ResponseEntity<SuccessResponse<AnalysisResponse>>analysis(@MemberId final Long memberId){
        AnalysisResponse response = chatserverService.getAnalysis(memberId);
        return ResponseEntity.ok().body(success(SUCCESS_ANALYSIS.getMessage(), response));
    }
}
