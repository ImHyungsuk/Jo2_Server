package com.jo2.server.chatting.controller;

import com.jo2.server.chatting.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chatting")
public class ChattingController {

    private final ChattingService chattingService;
}
