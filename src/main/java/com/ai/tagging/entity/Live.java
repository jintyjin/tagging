package com.ai.tagging.entity;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Live extends DataJpaBaseEntity {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

    public Live(Member member, Device device) {
        this.member = member;
        if (member.getLiveList().contains(this)) {
            member.getLiveList().remove(this);
        }
        member.getLiveList().add(this);
        this.device = device;
        if (device.getLiveList().contains(this)) {
            device.getLiveList().remove(this);
        }
        device.getLiveList().add(this);
    }
}
