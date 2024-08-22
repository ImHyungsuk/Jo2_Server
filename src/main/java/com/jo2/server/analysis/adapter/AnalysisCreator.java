package com.jo2.server.analysis.adapter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.analysis.repository.AnalysisRepository;
import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.member.entity.Member;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AnalysisCreator {

    private final AnalysisRepository analysisRepository;

    public Long createAnalysis(final Member member, final Long weatherId, final String result){
        Analysis analysis = Analysis.of(
                member,
                weatherId,
                result
        );
        analysisRepository.save(analysis);
        return analysis.getId();
    }
}
