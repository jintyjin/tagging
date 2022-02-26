package com.ai.tagging.controller.member;

import com.ai.tagging.dto.member.ResponseMembersDto;
import com.ai.tagging.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/request/members")
    private ResponseMembersDto memberList() {
        ResponseMembersDto responseMembersDto = new ResponseMembersDto();

        try {
            responseMembersDto.setStatus("200");
            responseMembersDto.setMemberDtoList(memberService.memberDtoList());
        } catch (Exception e) {
            responseMembersDto.setStatus("500");
            throw e;
        } finally {
            return responseMembersDto;
        }
    }

}
