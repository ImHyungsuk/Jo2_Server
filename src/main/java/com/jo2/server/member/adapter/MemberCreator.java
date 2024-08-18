package com.jo2.server.member.adapter;

import com.jo2.server.auth.social.SocialType;
import com.jo2.server.member.entity.Member;
import com.jo2.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import lombok.AccessLevel;

@Component
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberCreator {
    private final MemberRepository memberRepository;

    public Long createMember(final String socialId, final SocialType socialType, final String email) {
        Member member = Member.of(
                email,
                socialId,
                socialType
        );
        memberRepository.save(member);
        return member.getId();
    }
}
