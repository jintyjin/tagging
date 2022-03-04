package com.ai.tagging.service.insertImage;

import com.ai.tagging.dto.insertImage.ImageType;
import com.ai.tagging.dto.insertImage.InsertImageDto;
import com.ai.tagging.dto.insertImage.InsertImageStatus;
import com.ai.tagging.entity.InsertImage;
import com.ai.tagging.entity.device.Device;
import com.ai.tagging.repository.device.DeviceRepository;
import com.ai.tagging.repository.insertImage.InsertImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsertImageServiceImpl implements InsertImageService {

    private final DeviceRepository deviceRepository;
    private final InsertImageRepository insertImageRepository;

    @Override
    public InsertImageStatus insertQ(InsertImageDto insertImageDto) {
        List<Device> findDevice = deviceRepository.findByCh(insertImageDto.getDev_ch());
        if (findDevice.size() == 0) {
            InsertImageStatus imageStatus = new InsertImageStatus();
            imageStatus.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            imageStatus.setInfo("Channel must be only one but more");
            return imageStatus;
        }

        try {
            InsertImage insertImage = new InsertImage(findDevice.get(0), insertImageDto.getImg_data(), ImageType.valueOf(insertImageDto.getImg_type().toUpperCase()));   // 장비에 등록된 ID, PW로 추가 비교 필요(수정 예정)

            if (insertImageRepository.add(insertImage)) {
                InsertImageStatus imageStatus = new InsertImageStatus();
                imageStatus.setStatus(HttpStatus.OK.value());
                imageStatus.setInfo("OK");
                return imageStatus;
            }
        } catch (IllegalArgumentException e) {
            InsertImageStatus imageStatus = new InsertImageStatus();
            imageStatus.setStatus(HttpStatus.BAD_REQUEST.value());
            imageStatus.setInfo("Bad request error");
            return imageStatus;
        }

        InsertImageStatus imageStatus = new InsertImageStatus();
        imageStatus.setStatus(HttpStatus.BAD_REQUEST.value());
        imageStatus.setInfo("Bad request error");
        return imageStatus;
    }

    @Override
    public boolean deleteAll() {
        return insertImageRepository.clear();
    }
}
