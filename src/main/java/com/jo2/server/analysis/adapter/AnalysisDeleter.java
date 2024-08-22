package com.jo2.server.analysis.adapter;

import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.analysis.repository.AnalysisRepository;
import com.jo2.server.common.support.RepositoryAdapter;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class AnalysisDeleter {

    private final AnalysisRepository analysisRepository;

    public void delete(Long analysisId){analysisRepository.deleteById(analysisId);}
}
