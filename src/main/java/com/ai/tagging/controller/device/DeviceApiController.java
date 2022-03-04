package com.ai.tagging.controller.device;

import com.ai.tagging.dto.device.ResponseDeviceDto;
import com.ai.tagging.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
            responseDeviceDto.setStatus(HttpStatus.OK.value());
            responseDeviceDto.setInfo("OK");
            responseDeviceDto.setDeviceDtoList(deviceService.deviceDtoList());
            return responseDeviceDto;
        } catch (Exception e) {
            responseDeviceDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseDeviceDto.setInfo("Failed");
            return responseDeviceDto;
        }
    }
}
