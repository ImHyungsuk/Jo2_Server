package com.jo2.server.analysis.repository;

import com.jo2.server.analysis.entity.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisRepository extends JpaRepository<Analysis, Long> {

}
