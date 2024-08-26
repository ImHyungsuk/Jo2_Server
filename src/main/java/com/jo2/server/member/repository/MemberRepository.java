package com.jo2.server.member.repository;

import com.jo2.server.auth.social.SocialType;
import com.jo2.server.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long memberId);
    Optional<Member>findBySocialIdAndSocialType(String socialId, SocialType socialType);
}
