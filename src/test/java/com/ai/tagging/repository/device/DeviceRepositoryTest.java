package com.ai.tagging.repository.device;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.device.RtspUrl;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeviceRepositoryTest {

    @Autowired DeviceRepository deviceRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void 장비_저장() {
        //given
        Device device = new Device("nvr01", "1234", 1, "장비1", "127.0.0.1", 8080, "00:00:0c:28:06");

        //when
        Device savedDevice = deviceRepository.save(device);
        Device findDevice = deviceRepository.findByCh(savedDevice.getCh()).get(0);

        //then
        Assertions.assertThat(savedDevice.getId()).isEqualTo(findDevice.getId());
        Assertions.assertThat(savedDevice.getCh()).isEqualTo(findDevice.getCh());

    }

}