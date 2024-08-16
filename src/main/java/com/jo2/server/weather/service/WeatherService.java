package com.jo2.server.weather.service;

import com.jo2.server.member.entity.Member;
import com.jo2.server.weather.adapter.WeatherFinder;
import com.jo2.server.weather.dto.reponse.AllWeatherResponse;
import com.jo2.server.weather.dto.reponse.RecentWeatherResponse;
import com.jo2.server.weather.entity.Weather;
import com.jo2.server.weather.entity.WeatherList;
import java.nio.file.Watchable;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WeatherService {

    private WeatherFinder weatherFinder;

    public RecentWeatherResponse getRecentWeather(long memberId) {
        Optional<Weather> weather = weatherFinder.findTopByMemberIdOrderByCreatedAtDesc(memberId);
        if (weather.isPresent()) {
            int score = weather.get().getScoreVO().getScore();
            return RecentWeatherResponse.from(score);
        } else {
            return RecentWeatherResponse.from(0);
        }
    }

    public AllWeatherResponse getAllWeather(long memberId) {
        WeatherList weatherList = weatherFinder.findAllById(memberId);
        return AllWeatherResponse.from(weatherList);
    }
}
