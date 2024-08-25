package com.jo2.server.analysis.adapter;

import com.jo2.server.analysis.entity.Analysis;
import com.jo2.server.analysis.repository.AnalysisRepository;
import com.jo2.server.member.entity.Member;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AnalysisSaver {
    private final AnalysisRepository analysisRepository;

    public void createAnalysis(final Member member, final Long weatherId, final String result){
        Analysis analysis = Analysis.of(
                member,
                weatherId,
                result
        );
        analysisRepository.save(analysis);
    }
}
