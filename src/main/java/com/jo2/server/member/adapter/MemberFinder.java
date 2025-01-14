package com.jo2.server.member.adapter;

import static com.jo2.server.member.message.ErrorCode.MEMBER_NOT_FOUND;

import com.jo2.server.member.exception.MemberException;
import com.jo2.server.auth.social.SocialType;
import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.member.entity.Member;
import com.jo2.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class MemberFinder {

    private final MemberRepository memberRepository;

    public Member findById(long memberId) {
        return memberRepository.findById(memberId).orElseThrow(()-> new MemberException(MEMBER_NOT_FOUND));
    }
    public boolean isExistingUser(
            final String socialId,
            final SocialType socialType
            ) {
        return memberRepository.findBySocialIdAndSocialType(socialId, socialType).isPresent();
    }

    public Member getBySocialId(
            final String socialId,
            final SocialType socialType
    ) {
        return memberRepository.findBySocialIdAndSocialType(socialId, socialType).orElseThrow(
                () -> new MemberException(MEMBER_NOT_FOUND)
        );
    }
}
