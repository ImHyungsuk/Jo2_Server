package com.jo2.server.chatserver.controller;

import com.jo2.server.chatserver.service.ChatserverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat-server")
public class ChatserverController {

    private final ChatserverService chatserverService;
}
