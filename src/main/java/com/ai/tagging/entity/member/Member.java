package com.ai.tagging.entity.member;

import com.ai.tagging.entity.DataJpaBaseEntity;
import com.ai.tagging.entity.Live;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends DataJpaBaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String loginId;

    @Column(name = "member_pw")
    private String pw;

    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @OneToMany(mappedBy = "member")
    private List<Live> liveList = new ArrayList<>();

    public Member(String name, String loginId, String pw, String phoneNumber, Address address, MemberStatus memberStatus, Grade grade) {
        this.name = name;
        this.loginId = loginId;
        this.pw = pw;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.memberStatus = memberStatus;
        this.grade = grade;
    }
}
