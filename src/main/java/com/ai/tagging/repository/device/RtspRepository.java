package com.ai.tagging.repository.device;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.device.RtspUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RtspRepository extends JpaRepository<RtspUrl, Long> {

    void deleteAllByDevice(Device device);
}
