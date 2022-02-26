package com.ai.tagging.dto.member;

import com.ai.tagging.dto.device.DeviceDto;
import com.ai.tagging.entity.member.Grade;
import com.ai.tagging.entity.member.Member;
import com.ai.tagging.entity.member.MemberStatus;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MemberDto {
    private String loginId;
    private String name;
    private MemberStatus memberStatus;
    private Grade grade;
    private List<DeviceDto> deviceList;

    public MemberDto(Member member) {
        this.loginId = member.getLoginId();
        this.name = member.getName();
        this.memberStatus = member.getMemberStatus();
        this.grade = member.getGrade();
        this.deviceList = member.getLiveList()
                .stream()
                .map(l -> new DeviceDto(l.getDevice()))
                .collect(Collectors.toList());
    }
}
