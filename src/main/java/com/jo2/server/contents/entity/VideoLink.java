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
    FIRST("https://www.youtube.com/watch?v=63lwpjJaCj0", "리롤 카타 입니다"),
    SECOND("https://www.youtube.com/watch?v=QB_ZCtVuQx4","리롤 워윅 덱 가자"),
    THIRD("https://www.youtube.com/watch?v=kDN3OjFPhco","고벨류 라이즈로 갑시다"),
    FORTH("https://www.youtube.com/watch?v=8KYpGh_-GF8","행운에 뇌가 절여짐"),
    FIFTH("https://www.youtube.com/watch?v=oUzRA1KDsTU","아르카나 제라수우우")
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
            String imageLink = " https://img.youtube.com/vi/" + idPart + "/0.jpg";
            return new VideoCard(link,imageLink,title);
        }
    }
}
