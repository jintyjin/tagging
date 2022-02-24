package com.ai.tagging.controller.device;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.repository.device.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceRepository deviceRepository;

    @GetMapping("/devices")
    public String deviceList(Model model) {
        List<Device> deviceList = deviceRepository.findAll();
        model.addAttribute("deviceList", deviceList);

        return null;
    }
}
