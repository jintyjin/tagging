package com.ai.tagging.service.insertImage;

import com.ai.tagging.dto.insertImage.InsertImageDto;
import com.ai.tagging.dto.insertImage.InsertImageStatus;

public interface InsertImageService {

    InsertImageStatus insertQ(InsertImageDto insertImageDto);

    boolean deleteAll();
}
