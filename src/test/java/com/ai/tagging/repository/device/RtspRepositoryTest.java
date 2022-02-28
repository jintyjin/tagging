package com.ai.tagging.repository.device;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.device.DeviceStatus;
import com.ai.tagging.entity.device.RtspUrl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RtspRepositoryTest {

    @Autowired DeviceRepository deviceRepository;
    @Autowired RtspRepository rtspRepository;

    @Test
    @Transactional
    void rtsp_save() {
        //given
        Device device = new Device("nvr01", "1234", 1, "장비1", "127.0.0.1", 8080, "00:00:0c:28:06", DeviceStatus.FIXING);
        RtspUrl rtspUrl = new RtspUrl("rtsp://127.0.0.1/onvif-media", device);

        //when
        Device savedDevice = deviceRepository.save(device);
        RtspUrl savedRtspUrl = rtspRepository.save(rtspUrl);

        //then
        Assertions.assertThat(savedDevice.getId()).isEqualTo(savedRtspUrl.getDevice().getId());
    }

    @Test
    @Transactional
    void rtsp_delete() {
        //given
        Device device = new Device("nvr01", "1234", 1, "장비1", "127.0.0.1", 8080, "00:00:0c:28:06", DeviceStatus.BROKEN);
        RtspUrl rtspUrl = new RtspUrl("rtsp://127.0.0.1/onvif-media", device);

        //when
        Device savedDevice = deviceRepository.save(device);
        RtspUrl savedRtspUrl = rtspRepository.save(rtspUrl);

        //then
        rtspRepository.deleteAllByDevice(savedDevice);
        deviceRepository.delete(savedDevice);
    }
}