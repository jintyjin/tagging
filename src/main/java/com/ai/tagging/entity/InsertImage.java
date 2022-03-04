package com.ai.tagging.entity;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.dto.insertImage.ImageType;
import lombok.Getter;

@Getter
public class InsertImage {

    private Device device;
    private String base64;
    private ImageType imageType;

    public InsertImage(Device device, String base64, ImageType imageType) {
        this.device = device;
        this.base64 = base64;
        this.imageType = imageType;
    }
}
