package com.ai.tagging.repository.insertImage;

import com.ai.tagging.entity.InsertImage;

public interface InsertImageRepository {

    int size();

    boolean add(InsertImage insertImage);

    boolean clear();
}
