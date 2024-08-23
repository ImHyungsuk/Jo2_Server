package com.jo2.server.contents.dto.reponse;

import java.util.List;

public record MainSentenceGetResponse(
        String sentence
 ) {
    public static MainSentenceGetResponse from(String sentence) {
        return new MainSentenceGetResponse(sentence);
    }
}
