package com.jo2.server.chatserver.service;

import com.jo2.server.chatserver.client.ChatserverClient;
import com.jo2.server.chatserver.dto.response.ChatserverStartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ChatserverService {
    private final ChatserverClient chatserverClient;

    public ChatserverStartResponse startChatserver(
            final Long memberId
    ) {
        ChatserverStartResponse response = chatserverClient.startServer(memberId);
        return response;
    }
}
