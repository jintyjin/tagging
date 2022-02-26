package com.ai.tagging.dto.member;

import com.ai.tagging.dto.member.MemberDto;
import lombok.Data;

import java.util.List;

@Data
public class ResponseMembersDto {

    private String status;
    private List<MemberDto> memberDtoList;

}
