package com.ai.tagging.repository.event.time;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TimeRepository {

    Optional<LocalDateTime> findTimeByCh(int ch);

    boolean compareTime(int ch, LocalDateTime time);
}
