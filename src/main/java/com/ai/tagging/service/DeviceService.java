package com.ai.tagging.service;

import com.ai.tagging.dto.device.DeviceDto;
import com.ai.tagging.entity.device.Device;
import com.ai.tagging.repository.device.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public List<DeviceDto> deviceDtoList() {
        return makeDeviceDtoList(deviceRepository.findAll());
    }

    private List<DeviceDto> makeDeviceDtoList(List<Device> deviceList) {
        return deviceList.stream()
                .map(d -> new DeviceDto(d))
                .collect(Collectors.toList());
    }
}
