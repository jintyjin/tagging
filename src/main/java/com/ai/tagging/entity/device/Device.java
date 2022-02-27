package com.ai.tagging.entity.device;

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
public class Device extends DataJpaBaseEntity {

    @Id @GeneratedValue
    @Column(name = "device_id")
    private Long id;

    @Column(name = "device_name")
    private String name;

    private String loginId;

    @Column(name = "device_pw")
    private String pw;

    private int ch;

    private String ip;

    private int port;

    private String macAddress;

    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus;

    @OneToMany(mappedBy = "device")
    private List<RtspUrl> rtspUrlList = new ArrayList<>();

    @OneToMany(mappedBy = "device")
    private List<Live> liveList = new ArrayList<>();

    public Device(String loginId, String pw, int ch, String name, String ip, int port, String macAddress, DeviceStatus status) {
        this.loginId = loginId;
        this.pw = pw;
        this.name = name;
        this.ch = ch;
        this.ip = ip;
        this.port = port;
        this.macAddress = macAddress;
        this.deviceStatus = status;
    }
}
