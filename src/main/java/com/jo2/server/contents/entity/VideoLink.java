package com.jo2.server.contents.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VideoLink {
    FIRST("https://youtu.be/ENf6DQu5M4g?si=gRw-uNLMxnOlHbfB", "우울증 환자가 '이것'을 꼭 해야 하는 이유"),
    SECOND("https://youtu.be/Vd_XfWaFieM?si=7yNOCvFxAZBaLgrT","우울증 관리하며 살아갑니다"),
    THIRD("https://www.youtube.com/watch?v=B8oRH3PBbyg","정신과 의사가 말하는 가장 좋은 위로 방법"),
    FORTH("https://www.youtube.com/watch?v=6VEnTQ2rx_4","지치고 힘든 당신에게 위로가 되는 드라마속 명대사"),
    FIFTH("https://www.youtube.com/watch?v=JzZ-Whd_HsU","청소년 우울증에 대처하는 방법?")
    ;
    private final String link;
    private final String title;

    public static List<VideoCard> getVideoCard(){
        List<VideoLink> videoLinks = new ArrayList<>(List.of(VideoLink.values()));
        Collections.shuffle(videoLinks);
        List<VideoCard> randomSentences = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            VideoLink videoLink = videoLinks.get(i);
            randomSentences.add(VideoCard.of(videoLink.getLink(),videoLink.getTitle()));
        }
        return randomSentences;
    }

    @Getter
    @AllArgsConstructor
    public static class VideoCard{
        String link;
        String imageLink;
        String title;

        public static VideoCard of(String link, String title){
            String[] parts = link.split("v=");
            String idPart = null;
            if (parts.length > 1) {
                idPart = parts[1];
            }
            if(idPart ==null){
                throw new NullPointerException();
            }
            String imageLink = " https://img.youtube.com/vi/" + idPart + "/maxresdefault.jpg";
            return new VideoCard(link,imageLink,title);
        }
    }
}
