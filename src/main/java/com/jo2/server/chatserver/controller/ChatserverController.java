package com.jo2.server.chatserver.controller;

import static com.jo2.server.common.dto.SuccessResponse.success;
import static com.jo2.server.chatserver.message.SuccessMessage.SUCCESS_START_CHATTING;

import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import com.jo2.server.chatserver.service.ChatserverService;
import com.jo2.server.common.dto.SuccessResponse;
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
    public ResponseEntity<SuccessResponse<?>> startChatting(Principal principal) {
        Long memberId = Long.parseLong(principal.getName());
        ChatserverStartResponse response = chatserverService.startChatserver(memberId);

        return ResponseEntity.ok().body(success(SUCCESS_START_CHATTING.getMessage(), response));
    }
}
