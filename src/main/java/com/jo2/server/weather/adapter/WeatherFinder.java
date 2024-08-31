package com.jo2.server.weather.adapter;

import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.weather.repository.WeatherRepository;
import com.jo2.server.weather.vo.WeatherVO;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class WeatherFinder {
    private final WeatherRepository weatherRepository;

    public Optional<WeatherVO> findTopByMemberIdOrderByCreatedAtDesc(long memberId) {
        return weatherRepository.findTopByMemberIdOrderByCreatedAtDesc(memberId);
    }

    public List<WeatherVO> findAllById(long memberId) {
        return weatherRepository.findAllByMemberId(memberId);
    }
}
