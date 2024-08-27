package com.jo2.server.weather.service;

import com.jo2.server.member.adapter.MemberFinder;
import com.jo2.server.member.entity.Member;
import com.jo2.server.weather.adapter.WeatherFinder;
import com.jo2.server.weather.adapter.WeatherSaver;
import com.jo2.server.weather.dto.reponse.AllWeatherResponse;
import com.jo2.server.weather.dto.reponse.RecentWeatherResponse;
import com.jo2.server.weather.dto.reponse.WeatherCreateResponse;
import com.jo2.server.weather.dto.request.WeatherCreateRequest;
import com.jo2.server.weather.entity.Weather;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class WeatherService {

    private final WeatherFinder weatherFinder;
    private final WeatherSaver weatherSaver;
    private final MemberFinder memberFinder;

    public RecentWeatherResponse getRecentWeather(long memberId) {
        log.info("접속 멤버 아이디: " + memberId);
        Optional<Weather> weather = weatherFinder.findTopByMemberIdOrderByCreatedAtDesc(memberId);
        if (weather.isPresent()) {
            int score = weather.get().getScoreVO().getScore();
            return RecentWeatherResponse.from(score);
        } else {
            return RecentWeatherResponse.from(0);
        }
    }

    public AllWeatherResponse getAllWeather(long memberId) {
        log.info("접속 멤버 아이디: " + memberId);
        List<Weather> weatherList = weatherFinder.findAllById(memberId);
        return AllWeatherResponse.from(weatherList);
    }

    @Transactional
    public WeatherCreateResponse createWeather(WeatherCreateRequest weatherCreateRequest) {
        Member member = memberFinder.findById(weatherCreateRequest.userId());
        Weather weather = weatherSaver.save(Weather.of(member, weatherCreateRequest.overallScore(),
                weatherCreateRequest.overallAnalyze(), LocalDate.now()));
        return WeatherCreateResponse.from(weather.getId());
    }
}
