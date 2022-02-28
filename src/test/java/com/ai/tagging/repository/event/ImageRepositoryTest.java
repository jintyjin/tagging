package com.ai.tagging.repository.event;

import com.ai.tagging.entity.event.image.Image;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImageRepositoryTest {

    @Autowired
    ImageRepository imageRepository;

    @Test
    @Transactional
    void save() {
        Image image = new Image("1.jpg", "1_thumb.jpg", 1920, 1080);

        Image savedImage = imageRepository.save(image);
        Image findImage = imageRepository.findById(savedImage.getId()).get();

        Assertions.assertThat(savedImage.getId()).isEqualTo(findImage.getId());

    }
}