package com.jo2.server.analysis.adapter;

import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.analysis.repository.AnalysisRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AnalysisSaver {
    private final AnalysisRepository analysisRepository;

    public void createAnalysis(Analysis analysis){
        analysisRepository.save(analysis);
    }
}
