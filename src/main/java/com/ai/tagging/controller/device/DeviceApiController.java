package com.ai.tagging.controller.device;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.repository.device.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeviceApiController {

    private final DeviceRepository deviceRepository;

    @PostMapping("/request/devices")
    public List<Device> deviceList() {
        return deviceRepository.findAll();
    }
}
