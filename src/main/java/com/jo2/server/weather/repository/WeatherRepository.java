package com.jo2.server.weather.repository;

import com.jo2.server.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather,Long> {
}
