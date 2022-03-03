package com.ai.tagging.repository.event.time;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TimeRepositoryImpl implements TimeRepository {

    private static Map<Integer, LocalDateTime> timeList = new ConcurrentHashMap<>();

    @Override
    public Optional<LocalDateTime> findTimeByCh(int ch) {
        return getTime(ch);
    }

    /**
     * 이벤트가 들어오는 주기가 1초 이상인지를 확인하는 함수
     * 비교하는 시간의 최소 단위가 초인 것을 전제 조건으로 isAfter 함수를 사용함
     */
    @Override
    public boolean compareTime(int ch, LocalDateTime time) {
        if (!isPresent(ch) || isAfter(ch, time)) {
            saveTime(ch, time);
            return true;
        }
        return false;
    }

    private Optional<LocalDateTime> getTime(int ch) {
        return Optional.ofNullable(timeList.get(ch));
    }

    private void saveTime(int ch, LocalDateTime time) {
        timeList.put(ch, time);
    }

    private boolean isAfter(int ch, LocalDateTime time) {
        return isPresent(ch) && time.isAfter(getTime(ch).get());
    }

    private boolean isPresent(int ch) {
        return getTime(ch).isPresent();
    }
}
