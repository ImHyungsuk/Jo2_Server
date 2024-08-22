package com.jo2.server.analysis.adapter;

import com.jo2.server.analysis.repository.AnalysisRepository;
import com.jo2.server.common.support.RepositoryAdapter;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class AnalysisSaver {
    private final AnalysisRepository analysisRepository;
}
