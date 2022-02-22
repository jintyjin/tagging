package com.ai.tagging.repository.member;

import com.ai.tagging.entity.member.Member;

import java.util.List;

public interface MemberRepository {

    Long save(Member member);

    Member findById(Long id);

    List<Member> findAll();
}
