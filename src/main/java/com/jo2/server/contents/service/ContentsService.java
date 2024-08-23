package com.jo2.server.contents.service;

import com.jo2.server.contents.dto.reponse.MainSentenceGetResponse;
import com.jo2.server.contents.dto.reponse.VideoCardsGetResponse;
import com.jo2.server.contents.entity.MainSentence;
import com.jo2.server.contents.entity.VideoLink;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContentsService {

    public MainSentenceGetResponse getMainSentence(){
        return MainSentenceGetResponse.from(MainSentence.getRandomSentence());
    }

    public VideoCardsGetResponse getVideoCards(){
        return VideoCardsGetResponse.from(VideoLink.getVideoCard());
    }
}
