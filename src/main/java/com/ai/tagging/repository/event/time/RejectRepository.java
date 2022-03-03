package com.ai.tagging.repository.event.time;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RejectRepository {

    void saveTime(int ch, LocalDateTime time);

    Optional<LocalDateTime> findTimeByCh(int ch);

    boolean compareTime(int ch, LocalDateTime time);
}
