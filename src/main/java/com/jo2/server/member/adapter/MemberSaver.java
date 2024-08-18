package com.jo2.server.member.adapter;

import com.jo2.server.common.support.RepositoryAdapter;
import com.jo2.server.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RepositoryAdapter
@RequiredArgsConstructor
public class MemberSaver {

    private final MemberRepository memberRepository;

}
