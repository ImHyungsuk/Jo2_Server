package com.jo2.server.member.repository;

import com.jo2.server.auth.social.SocialType;
import com.jo2.server.member.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Member> findBySocialTypeAndSocialId(
            final String socialId,
            final SocialType socialType
    ) {
        return null;
//        return Optional.ofNullable(
//                jpaQueryFactory.selectFrom(member)
//                        .where(
//                                member.socialId.eq(socialId),
//                                member.socialType.eq(socialType)
//                        )
//                        .fetchOne()
//        );
    }
}
