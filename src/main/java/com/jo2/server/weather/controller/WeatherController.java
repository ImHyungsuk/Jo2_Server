package com.jo2.server.weather.controller;

import static com.jo2.server.common.dto.SuccessResponse.success;
import static com.jo2.server.weather.message.SuccessMessage.SUCCESS_GET_ALL_RESULT;
import static com.jo2.server.weather.message.SuccessMessage.SUCCESS_GET_RECENT_RESULT;

import com.jo2.server.common.dto.SuccessResponse;
import com.jo2.server.common.resolver.member.MemberId;
import com.jo2.server.weather.dto.reponse.AllWeatherResponse;
import com.jo2.server.weather.dto.reponse.RecentWeatherResponse;
import com.jo2.server.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<SuccessResponse<AllWeatherResponse>> getResult(@MemberId final Long memberId) {
        AllWeatherResponse response = weatherService.getAllWeather(memberId);
        return ResponseEntity.ok().body(success(SUCCESS_GET_ALL_RESULT.getMessage(), response));
    }

    @GetMapping("/recent")
    public ResponseEntity<SuccessResponse<RecentWeatherResponse>> getRecentResult(@MemberId final Long memberId) {
        RecentWeatherResponse response = weatherService.getRecentWeather(memberId);
        return ResponseEntity.ok().body(success(SUCCESS_GET_RECENT_RESULT.getMessage(), response));
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<RecentWeatherResponse>> saveWeather(@MemberId final Long memberId) {
        RecentWeatherResponse response = weatherService.getRecentWeather(memberId);
        return ResponseEntity.ok().body(success(SUCCESS_GET_RECENT_RESULT.getMessage(), response));
    }
}
