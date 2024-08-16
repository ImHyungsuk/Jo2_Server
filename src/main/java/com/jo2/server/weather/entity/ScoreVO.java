package com.jo2.server.weather.entity;

import static com.jo2.server.weather.message.ErrorCode.RANGE_EXCEPTION;

import com.jo2.server.weather.exception.WeatherException;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@NoArgsConstructor
@Getter
public class ScoreVO {

    private int score;

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 100;

    public ScoreVO(int score) {
        validateNumberIsInRange(score);
        this.score = score;
    }

    public static ScoreVO from(int score) {
        return new ScoreVO(score);
    }

    private void validateNumberIsInRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new WeatherException(RANGE_EXCEPTION);
        }
    }
}
