package com.ai.tagging.service.insertImage;

import com.ai.tagging.dto.insertImage.ImageType;
import com.ai.tagging.dto.insertImage.InsertImageDto;
import com.ai.tagging.dto.insertImage.InsertImageStatus;
import com.ai.tagging.repository.insertImage.InsertImageRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InsertImageServiceImplTest {

    @Autowired InsertImageService insertImageService;

    @Test
    void insertQ() {
        //given
        InsertImageDto insertImageDto1 = new InsertImageDto();
        insertImageDto1.setDev_ch(1);
        insertImageDto1.setDev_id("아이디1");
        insertImageDto1.setDev_pw("12345");
        insertImageDto1.setImg_data("이미지1");
        insertImageDto1.setImg_type("jpg");

        InsertImageDto insertImageDto2 = new InsertImageDto();
        insertImageDto2.setDev_ch(3);
        insertImageDto2.setDev_id("아이디2");
        insertImageDto2.setDev_pw("12345");
        insertImageDto2.setImg_data("이미지2");
        insertImageDto2.setImg_type("png");

        InsertImageDto insertImageDto3 = new InsertImageDto();
        insertImageDto3.setDev_ch(10);
        insertImageDto3.setDev_id("아이디3");
        insertImageDto3.setDev_pw("12345");
        insertImageDto3.setImg_data("이미지3");
        insertImageDto3.setImg_type("png");

        InsertImageDto insertImageDto4 = new InsertImageDto();
        insertImageDto4.setDev_ch(5);
        insertImageDto4.setDev_id("아이디4");
        insertImageDto4.setDev_pw("12345");
        insertImageDto4.setImg_data("이미지4");
        insertImageDto4.setImg_type("gif");

        //when
        InsertImageStatus insertImageStatus1 = insertImageService.insertQ(insertImageDto1);
        InsertImageStatus insertImageStatus2 = insertImageService.insertQ(insertImageDto2);
        InsertImageStatus insertImageStatus3 = insertImageService.insertQ(insertImageDto3);
        InsertImageStatus insertImageStatus4 = insertImageService.insertQ(insertImageDto4);

        //then
        assertThat(insertImageStatus1.getStatus()).isEqualTo(200);
        assertThat(insertImageStatus1.getInfo()).isEqualTo("OK");
        assertThat(insertImageStatus2.getStatus()).isEqualTo(200);
        assertThat(insertImageStatus2.getInfo()).isEqualTo("OK");
        assertThat(insertImageStatus3.getStatus()).isEqualTo(500);
        assertThat(insertImageStatus3.getInfo()).isEqualTo("Channel must be only one but more");
        assertThat(insertImageStatus4.getStatus()).isEqualTo(400);
        assertThat(insertImageStatus4.getInfo()).isEqualTo("Bad request error");

    }
}