package com.ai.tagging.repository.device;

import com.ai.tagging.entity.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findByCh(int ch);
}
