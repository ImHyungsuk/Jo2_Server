package com.jo2.server.member.adapter;

import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class MemberFinder {

    private final MemberRepository memberRepository;
}
