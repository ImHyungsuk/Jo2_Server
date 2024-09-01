package com.jo2.server.analysis.entity;

import com.jo2.server.common.entity.BaseTime;
import com.jo2.server.member.entity.Member;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Builder
@Getter
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

    @Column(length = 500)
    private String result;

    public static Analysis of(
            Member member,
            String result
    ) {
        return Analysis.builder()
                .member(member)
                .result(result)
                .build();
    }

    public void updateResult(String result) {
        this.result = result;
    }

    public LocalDate toLoCalDate() {
        return updatedAt.toLocalDate();
    }
}
