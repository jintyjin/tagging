package com.ai.tagging.repository.event.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TimeRepositoryImplTest {

    @Test
    void checkOneSec() {
        final int CH = 1;

        //given
        TimeRepository timeRepository = new TimeRepositoryImpl();

        LocalDateTime beforeInsertImage = LocalDateTime.of(2022, 3, 3, 17, 0, 0);
        LocalDateTime errorInsertImage = LocalDateTime.of(2022, 3, 3, 17, 0, 0);
        LocalDateTime afterInsertImage = LocalDateTime.of(2022, 3, 3, 17, 0, 1);

        //when
        boolean savedBefore = timeRepository.compareTime(CH, beforeInsertImage);
        boolean savedError = timeRepository.compareTime(CH, errorInsertImage);
        boolean savedAfter = timeRepository.compareTime(CH, afterInsertImage);
        LocalDateTime time = timeRepository.findTimeByCh(CH).get();

        //then
        assertThat(savedBefore).isEqualTo(true);
        assertThat(savedError).isEqualTo(false);
        assertThat(savedAfter).isEqualTo(true);
        assertThat(time).isEqualTo(afterInsertImage);
    }
}