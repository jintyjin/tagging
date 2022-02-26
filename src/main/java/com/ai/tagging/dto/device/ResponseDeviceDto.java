package com.ai.tagging.dto.device;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDeviceDto {

    private String ststus;
    private List<DeviceDto> deviceDtoList;
}
