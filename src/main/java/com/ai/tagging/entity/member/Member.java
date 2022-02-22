package com.ai.tagging.entity.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    private LocalDateTime joinDate;

    private LocalDateTime loginDate;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Member(String name, String phoneNumber, Address address, MemberStatus memberStatus, Grade grade) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.memberStatus = memberStatus;
        this.joinDate = LocalDateTime.now();
        this.loginDate = LocalDateTime.now();
        this.grade = grade;
    }
}
