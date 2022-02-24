package com.ai.tagging.entity.device;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "rtsp_url")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RtspUrl {

    @Id
    @GeneratedValue
    @Column(name = "rtsp_url_id")
    private Long id;

    private String rtspUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

    public RtspUrl(String rtspUrl, Device device) {
        this.rtspUrl = rtspUrl;
        this.device = device;
        device.getRtspUrlList().add(this);
    }
}
