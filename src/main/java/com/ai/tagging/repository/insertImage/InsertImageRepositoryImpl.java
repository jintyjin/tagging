package com.ai.tagging.repository.insertImage;

import com.ai.tagging.entity.InsertImage;
import org.springframework.stereotype.Repository;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Repository
public class InsertImageRepositoryImpl implements InsertImageRepository {

    private static BlockingQueue<InsertImage> insertQ = new LinkedBlockingQueue<>();

    @Override
    public int size() {
        return insertQ.size();
    }

    @Override
    public boolean add(InsertImage insertImage) {
        return insertQ.offer(insertImage);
    }

    @Override
    public boolean clear() {
        try {
            insertQ.clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
