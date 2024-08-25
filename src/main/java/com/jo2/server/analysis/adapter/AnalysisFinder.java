package com.jo2.server.analysis.adapter;

import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.analysis.repository.AnalysisRepository;
import com.jo2.server.common.support.RepositoryAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RepositoryAdapter
@RequiredArgsConstructor
public class AnalysisFinder {

    private final AnalysisRepository analysisRepository;

    public Optional<Analysis> findAnalysisByMemberId(Long memberId){
        return analysisRepository.findByMemberId(memberId);
    }
}
