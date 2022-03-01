package com.ai.tagging.repository.event;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.device.DeviceStatus;
import com.ai.tagging.entity.event.Event;
import com.ai.tagging.entity.event.EventName;
import com.ai.tagging.entity.event.box.Box;
import com.ai.tagging.entity.event.box.Boxes;
import com.ai.tagging.entity.event.image.Image;
import com.ai.tagging.repository.device.DeviceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoxRepositoryTest {

    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    BoxRepository boxRepository;

    @Test
    @Transactional
    void save() {
        LocalDateTime time = LocalDateTime.parse("2022-02-28 13:04:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Device device = new Device("nvr05", "1235", 5, "장비5", "127.0.0.1", 8085, "00:00:0c:28:05", DeviceStatus.BROKEN);
        Image image = new Image("1.jpg", "1_thumb.jpg", 1920, 1080);
        Event event = new Event(EventName.KATER_Falldown_Detection, time, device, image);

        deviceRepository.save(device);
        imageRepository.save(image);
        eventRepository.save(event);
        Boxes savedBoxes = boxRepository.save(new Boxes("falldown", 99.01, event, 20, 10, 300, 400));
        Box findBoxes = boxRepository.findById(savedBoxes.getId()).get();

        assertThat(savedBoxes.getId()).isEqualTo(findBoxes.getId());

    }

}