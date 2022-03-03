package com.ai.tagging.controller.device;

import com.ai.tagging.dto.device.ResponseDeviceDto;
import com.ai.tagging.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class DeviceApiController {

    private final DeviceService deviceService;


    @GetMapping("/request/devices")
    public ResponseDeviceDto deviceList() {
        ResponseDeviceDto responseDeviceDto = new ResponseDeviceDto();

        try {
            responseDeviceDto.setStatus("200");
            responseDeviceDto.setDeviceDtoList(deviceService.deviceDtoList());
        } catch (Exception e) {
            responseDeviceDto.setStatus("500");
            throw e;
        } finally {
            return responseDeviceDto;
        }
    }
}
