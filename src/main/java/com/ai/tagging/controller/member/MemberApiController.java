package com.ai.tagging.controller.member;

import com.ai.tagging.dto.MemberDto;
import com.ai.tagging.dto.ResponseMembersDto;
import com.ai.tagging.entity.member.Address;
import com.ai.tagging.entity.member.Grade;
import com.ai.tagging.entity.member.Member;
import com.ai.tagging.entity.member.MemberStatus;
import com.ai.tagging.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberRepository memberRepository;

    @GetMapping("/request/members")
    private ResponseMembersDto memberList() {
        ResponseMembersDto responseMembersDto = new ResponseMembersDto();

        try {
            responseMembersDto.setStatus("200");
            responseMembersDto.setMemberDtoList(makeMemberDtoList(memberRepository.findAll()));
        } catch (Exception e) {
            responseMembersDto.setStatus("400");
            throw new Exception();
        } finally {
            return responseMembersDto;
        }
    }

    private List<MemberDto> makeMemberDtoList(List<Member> memberList) {
        return memberList.stream()
                .map(m -> new MemberDto(m))
                .collect(Collectors.toList());
    }
}
