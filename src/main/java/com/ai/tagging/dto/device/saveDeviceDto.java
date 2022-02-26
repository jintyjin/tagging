package com.ai.tagging.dto.device;

import lombok.Data;

@Data
public class saveDeviceDto {

    private String dev_id;
    private String dev_pw;
    private String dev_ch;
    private String dev_title;
    private String dev_ip;
    private Integer port;
    private String macAddress;
    private String rtspUrl;
}
