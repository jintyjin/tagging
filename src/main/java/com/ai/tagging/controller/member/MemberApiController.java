package com.ai.tagging.controller.member;

import com.ai.tagging.entity.member.Member;
import com.ai.tagging.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberRepository memberRepository;

    @PostMapping("/request/members")
    private List<Member> memberList() {
        return memberRepository.findAll();
    }
}
