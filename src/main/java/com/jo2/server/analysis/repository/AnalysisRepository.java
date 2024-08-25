package com.jo2.server.analysis.repository;

import com.jo2.server.analysis.entity.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AnalysisRepository extends JpaRepository<Analysis, Long> {

    @Query("SELECT a from Analysis  a WHERE a.member.id = :memberId")
    Optional<Analysis> findByMemberId(@Param("memberId") Long memberId);
}
