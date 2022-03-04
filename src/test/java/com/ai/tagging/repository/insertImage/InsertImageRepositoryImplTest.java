package com.ai.tagging.repository.insertImage;

import com.ai.tagging.dto.insertImage.ImageType;
import com.ai.tagging.entity.InsertImage;
import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.device.DeviceStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InsertImageRepositoryImplTest {

    InsertImageRepository insertImageRepository = new InsertImageRepositoryImpl();

    @Test
    void add_test() {
        //given
        InsertImage insertImage = new InsertImage(new Device("device", "12345", 1, "장비", "127.0.0.1", 8080, "12:ea:33:42", DeviceStatus.FIXING), "testImage", ImageType.JPG);

        //when
        insertImageRepository.add(insertImage);
        int size = insertImageRepository.size();

        //then
        assertThat(size).isEqualTo(1);
    }
}