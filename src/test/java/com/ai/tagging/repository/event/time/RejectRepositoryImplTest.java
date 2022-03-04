package com.ai.tagging.repository.event.time;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RejectRepositoryImplTest {

    @Test
    void save() {
        //given
        RejectRepository rejectRepository = new RejectRepositoryImpl();
        final int CH = 1;

        //when
        LocalDateTime now = LocalDateTime.of(2022, 3, 3, 17, 30, 0);
        rejectRepository.saveTime(CH, now);
        LocalDateTime time = rejectRepository.findTimeByCh(CH).get();

        //then
        assertThat(now).isEqualTo(time);

    }

    @Test
    void chkRejectTime() {
        //given
        final int CH = 1;
        final int REJECT_HOUR = 12;
        LocalDateTime now = LocalDateTime.of(2023, 3, 3, 17, 37, 0);
        RejectRepository rejectRepository = new RejectRepositoryImpl();
        rejectRepository.saveTime(CH, now.plusHours(REJECT_HOUR));

        //when
        boolean isRejectNow = rejectRepository.compareTime(CH, LocalDateTime.now());
        LocalDateTime afterReject = LocalDateTime.of(2023, 3, 3, 17, 38, 0);
        boolean isRejectAfter = rejectRepository.compareTime(CH, afterReject.plusHours(REJECT_HOUR));

        //then
        assertThat(isRejectNow).isEqualTo(false);
        assertThat(isRejectAfter).isEqualTo(true);
    }
}