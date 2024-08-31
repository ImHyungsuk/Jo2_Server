package com.jo2.server.weather.repository;

import com.jo2.server.weather.entity.Weather;
import com.jo2.server.weather.vo.WeatherVO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    @Query("SELECT w FROM Weather w WHERE w.member.id = :memberId ORDER BY w.createdAt DESC")
    Optional<WeatherVO> findTopByMemberIdOrderByCreatedAtDesc(@Param("memberId") Long memberId);

    List<WeatherVO> findAllByMemberId(Long memberId);

}
