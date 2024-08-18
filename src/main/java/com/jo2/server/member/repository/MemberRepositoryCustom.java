package com.jo2.server.member.repository;

import com.jo2.server.auth.social.SocialType;
import com.jo2.server.member.entity.Member;
import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findBySocialTypeAndSocialId(final String socialId, final SocialType socialType);
}
