package com.ai.tagging.repository.event.time;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class RejectRepositoryImpl implements RejectRepository {

    private static Map<Integer, LocalDateTime> rejectList = new ConcurrentHashMap<>();

    @Override
    public void saveTime(int ch, LocalDateTime time) {
        rejectList.put(ch, time);
    }

    @Override
    public Optional<LocalDateTime> findTimeByCh(int ch) {
        return getTime(ch);
    }

    /**
     * 특정 시간까지 이벤트를 받지 않는 무시 기능을 이용했을 때 특정 시간을 체크하는 함수
     */
    @Override
    public boolean compareTime(int ch, LocalDateTime time) {
        if (!isPresent(ch) || isAfter(ch, time)) {
            return true;
        }
        return false;
    }

    private Optional<LocalDateTime> getTime(int ch) {
        return Optional.ofNullable(rejectList.get(ch));
    }

    private boolean isAfter(int ch, LocalDateTime time) {
        return isPresent(ch) && time.isAfter(getTime(ch).get());
    }

    private boolean isPresent(int ch) {
        return getTime(ch).isPresent();
    }

}
