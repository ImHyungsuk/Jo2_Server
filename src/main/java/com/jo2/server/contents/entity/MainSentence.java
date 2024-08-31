package com.jo2.server.contents.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MainSentence {
    FIRST("햇빛은 달콤하고, 비는 상쾌하고,\n"
            + "바람은 시원하며, 눈은 기분을 들뜨게 만든다.\n"
            + "세상에 나쁜 날씨란 없다.\n"
            + "서로 다른 종류의 좋은 날씨만 있을 뿐.\n"
            + "-존 러스킨"),
    SECOND("수 없이 많은 별들 중에서도\n"
            + "그 어느 하나\n"
            + "빛을 내지 않는\n"
            + "별은 없다"),
    THIRD("좌절하지마세요. 당신 옆에는 좋은사람들이 많습니다."),
    FORTH("어떤 날은 구름이 햇빛을 가리지만, 그 뒤에 언제나 밝게 빛나는 해가 있다는 걸 잊지 마세요. 당신의 마음에도 다시 밝은 날이 올 거예요."),
    FIFTH("힘들 때일수록 자신에게 친절해지세요. 작은 일이라도 성취하는 자신을 칭찬하고, 한 걸음씩 앞으로 나아가는 당신은 그 자체로 소중하고 가치가 있어요.");
    private final String sentence;

    public static String getRandomSentence() {
        List<MainSentence> sentences = new ArrayList<>(List.of(MainSentence.values()));
        Collections.shuffle(sentences);
        return sentences.get(0).getSentence();
    }
}
