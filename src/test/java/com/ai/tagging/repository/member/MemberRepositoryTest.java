package com.ai.tagging.repository.member;

import com.ai.tagging.entity.member.Address;
import com.ai.tagging.entity.member.Grade;
import com.ai.tagging.entity.member.Member;
import com.ai.tagging.entity.member.MemberStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    void testMember() {
        //given
        Member member = new Member("유저1", "user1", "1234", "010-1234-5678", new Address("Seoul", "Daerim", "11111"), MemberStatus.Normal, Grade.MEMBER);

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.findById(savedId);

        //then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getName()).isEqualTo(member.getName());

        Member member2 = new Member("유저1", "user1", "1234", "010-1234-5678", new Address("Seoul", "Daerim", "11111"), MemberStatus.Normal, Grade.MEMBER);
        Member member3 = new Member("유저1", "user1", "1234", "010-1234-5678", new Address("Seoul", "Daerim", "11111"), MemberStatus.Normal, Grade.MEMBER);

    }
}