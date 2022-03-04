package com.ai.tagging.dto.device;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDeviceDto {

    private int status;
    private String info;
    private List<DeviceDto> deviceDtoList;

}
