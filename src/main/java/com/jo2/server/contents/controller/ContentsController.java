package com.jo2.server.contents.controller;

import static com.jo2.server.common.dto.SuccessResponse.success;
import static com.jo2.server.contents.message.SuccessMessage.SUCCESS_MAIN_SENTENCES;
import static com.jo2.server.contents.message.SuccessMessage.SUCCESS_VIDEO_CARDS;

import com.jo2.server.common.dto.SuccessResponse;
import com.jo2.server.contents.dto.reponse.MainSentenceGetResponse;
import com.jo2.server.contents.dto.reponse.VideoCardsGetResponse;
import com.jo2.server.contents.service.ContentsService;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contents")
public class ContentsController {

    private final ContentsService contentsService;

    @GetMapping("/main-sentence")
    public ResponseEntity<SuccessResponse<MainSentenceGetResponse>> mainSentenceGetResponse() {
        MainSentenceGetResponse response= contentsService.getMainSentence();
        return ResponseEntity.ok().body(success(SUCCESS_MAIN_SENTENCES.getMessage(), response));
    }

    @GetMapping("/video-links")
    public ResponseEntity<SuccessResponse<VideoCardsGetResponse>> videoLinksGetResponse () {
        VideoCardsGetResponse response= contentsService.getVideoCards();
        return ResponseEntity.ok().body(success(SUCCESS_VIDEO_CARDS.getMessage(), response));
    }
}
