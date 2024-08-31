package com.jo2.server.weather.vo;

import static lombok.AccessLevel.PRIVATE;

import com.jo2.server.weather.entity.PhqScoreVO;
import com.jo2.server.weather.entity.ScoreVO;
import com.jo2.server.weather.entity.Weather;
import io.micrometer.common.lang.NonNull;
import java.time.DayOfWeek;
import lombok.Builder;

@Builder(access = PRIVATE)
public record WeatherVO(
        @NonNull ScoreVO scoreVO,
        @NonNull PhqScoreVO phqScoreVO,
        @NonNull DayOfWeek dayOfWeek,
        @NonNull String result
        ) {
    public static WeatherVO from(Weather weather){
        return WeatherVO.builder()
                .scoreVO(weather.getScoreVO())
                .phqScoreVO(weather.getPhqScoreVO())
                .dayOfWeek(weather.getDayOfWeek())
                .result(weather.getResult())
                .build();
    }
}
