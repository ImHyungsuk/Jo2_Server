package com.jo2.server.contents.dto.reponse;

import com.jo2.server.contents.entity.VideoLink.VideoCard;
import java.util.List;

public record VideoCardsGetResponse(
        List<VideoCard> cards
 ) {
    public static VideoCardsGetResponse from(List<VideoCard> cards) {
        return new VideoCardsGetResponse(cards);
    }
}
