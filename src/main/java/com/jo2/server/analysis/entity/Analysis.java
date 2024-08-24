package com.jo2.server.analysis.entity;

import com.jo2.server.common.entity.BaseTime;
import com.jo2.server.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Analysis extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Long weatherId;
    private String result;

    public static Analysis of(
            Member member,
            Long weatherId,
            String result
    ){
        return Analysis.builder()
                .member(member)
                .weatherId(weatherId)
                .result(result)
                .build();
    }

    public void updateResult(String summary,Long weatherId)
    {
        this.result = summary;
        this.weatherId = weatherId;
    }
}
