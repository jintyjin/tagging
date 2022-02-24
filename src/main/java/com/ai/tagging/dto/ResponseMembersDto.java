package com.ai.tagging.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseMembersDto {

    private String status;
    private List<MemberDto> memberDtoList;

    public ResponseMembersDto(String status, List<MemberDto> memberDtoList) {
        this.status = status;
        this.memberDtoList = memberDtoList;
    }

    public ResponseMembersDto() {

    }
}
