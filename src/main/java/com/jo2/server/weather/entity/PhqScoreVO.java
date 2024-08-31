package com.jo2.server.weather.entity;

import com.jo2.server.weather.exception.WeatherException;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.jo2.server.weather.message.ErrorCode.RANGE_EXCEPTION;

@Embeddable
@NoArgsConstructor
@Getter
public class PhqScoreVO {

    private int phqscore;

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 36;

    public PhqScoreVO(int score) {
        validateNumberIsInRange(score);
        this.phqscore = score;
    }

    public static PhqScoreVO from(int score) {
        return new PhqScoreVO(score);
    }

    private void validateNumberIsInRange(int number) {
        if (number <= MIN_NUMBER || number >= MAX_NUMBER) {
            throw new WeatherException(RANGE_EXCEPTION);
        }
    }
}
