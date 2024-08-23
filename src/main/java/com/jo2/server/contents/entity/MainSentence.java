package com.jo2.server.contents.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MainSentence {
    FIRST("공략은 구루루"),
    SECOND("고르는 순간 최소 순방! 정말 쉽고 강력한 꿀덱 짜릿한 공격 블리츠크랭크덱 핵심공략"),
    THIRD("드디어 찾았습니다 1코 3성으로 9레벨을 밀어버리는 역대급 성능 리롤 세라핀덱 핵심공략"),
    FORTH("나오면 무조건 하세요 점수를 무한으로 복사시켜주는 형상변환자 스몰더덱 핵심공략"),
    FIFTH("이건 버프가 아니라 버그입니다 14.16패치 이후 떡상한 최대 수혜덱 리롤 카타리나덱 핵심공략")
    ;
    private final String sentence;
    public static String getRandomSentence(){
        List<MainSentence> sentences = new ArrayList<>(List.of(MainSentence.values()));
        Collections.shuffle(sentences);
        return sentences.get(0).getSentence();
    }
}
