package com.jo2.server.weather.dto.reponse;

import static lombok.AccessLevel.PRIVATE;

import com.jo2.server.weather.entity.ScoreVO;
import com.jo2.server.weather.vo.WeatherVO;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder(access = PRIVATE)
public record WeatherResponse(
        ScoreVO scoreVO,
        String result,
        String date
) {
    public static WeatherResponse from(WeatherVO weatherVO) {
        LocalDateTime dateTime = weatherVO.dateTime();
        return WeatherResponse.builder()
                .scoreVO(weatherVO.scoreVO())
                .result(weatherVO.result())
                .date(dateTime.getYear() + "." + dateTime.getMonth() + "." + dateTime.getDayOfMonth())
                .build();
    }
}