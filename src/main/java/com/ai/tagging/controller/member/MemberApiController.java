package com.ai.tagging.controller.member;

import com.ai.tagging.dto.member.ResponseMembersDto;
import com.ai.tagging.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
            responseMembersDto.setStatus(HttpStatus.OK.value());
            responseMembersDto.setInfo("OK");
            responseMembersDto.setMemberDtoList(memberService.memberDtoList());
            return responseMembersDto;
        } catch (Exception e) {
            responseMembersDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseMembersDto.setInfo("Failed");
            return responseMembersDto;
        }
    }

}
