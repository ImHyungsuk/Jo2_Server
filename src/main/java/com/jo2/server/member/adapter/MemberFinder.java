package com.jo2.server.member.adapter;

import com.jo2.server.chatserver.config.OpenFeignConfig;
import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.member.entity.Member;
import com.jo2.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RepositoryAdapter
@RequiredArgsConstructor
public class MemberFinder {

    private final MemberRepository memberRepository;

    public Optional<Member> findById(long memberId) {
        return memberRepository.findById(memberId);
    }
}
