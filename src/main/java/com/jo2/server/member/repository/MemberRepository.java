package com.jo2.server.member.repository;

import com.jo2.server.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> , MemberRepositoryCustom {
}
