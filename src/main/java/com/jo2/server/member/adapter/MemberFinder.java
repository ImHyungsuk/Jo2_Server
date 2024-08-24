package com.jo2.server.member.adapter;

import static com.jo2.server.member.message.ErrorCode.USER_NOT_FOUND;

import com.jo2.server.member.exception.MemberException;
import com.jo2.server.auth.social.SocialType;
import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.member.entity.Member;
import com.jo2.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RepositoryAdapter
@RequiredArgsConstructor
public class MemberFinder {

    private final MemberRepository memberRepository;

    public Optional<Member> findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
    public boolean isExistingUser(
            final String socialId,
            final SocialType socialType
            ) {
        return memberRepository.findBySocialTypeAndSocialId(socialId, socialType).isPresent();
    }

    public Member getBySocialId(
            final String socialId,
            final SocialType socialType
    ) {
        return memberRepository.findBySocialTypeAndSocialId(socialId, socialType).orElseThrow(
                () -> new MemberException(USER_NOT_FOUND)
        );
    }

}
