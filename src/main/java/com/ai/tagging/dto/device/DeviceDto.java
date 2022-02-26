package com.ai.tagging.dto.device;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.device.RtspUrl;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DeviceDto {

    private String name;
    private String loginId;
    private int ch;
    private String ip;
    private int port;
    private String macAddress;
    private List<String> rtspUrlList;

    public DeviceDto(Device device) {
        this.name = device.getName();
        this.loginId = device.getLoginId();
        this.ch = device.getCh();
        this.ip = device.getIp();
        this.port = device.getPort();
        this.macAddress = device.getMacAddress();
        this.rtspUrlList = device.getRtspUrlList()
                .stream()
                .map(rtspUrl -> rtspUrl.getRtspUrl())
                .collect(Collectors.toList());
    }
}
