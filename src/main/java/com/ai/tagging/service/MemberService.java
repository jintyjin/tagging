package com.ai.tagging.service;

import com.ai.tagging.dto.member.MemberDto;
import com.ai.tagging.entity.member.Member;
import com.ai.tagging.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberDto> memberDtoList() {
        return makeMemberDtoList(memberRepository.findAll());
    }

    private List<MemberDto> makeMemberDtoList(List<Member> memberList) {
        return memberList.stream()
                .map(m -> new MemberDto(m))
                .collect(Collectors.toList());
    }
}
