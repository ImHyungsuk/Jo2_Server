package com.jo2.server.weather.adapter;

import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.weather.entity.Weather;
import com.jo2.server.weather.repository.WeatherRepository;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class WeatherFinder {
    private final WeatherRepository weatherRepository;

    public Optional<Weather> findTopByMemberIdOrderByCreatedAtDesc(long memberId){
        return weatherRepository.findTopByMemberIdOrderByCreatedAtDesc(memberId);
    }

    public List<Weather> findAllById(long memberId){
        return weatherRepository.findAllById(memberId);
    }
}
