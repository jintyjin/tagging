package com.ai.tagging.controller;

import com.ai.tagging.dto.insertImage.InsertImageDto;
import com.ai.tagging.dto.ResponseEventDto;
import com.ai.tagging.service.insertImage.InsertImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeApiController {

    private final InsertImageService insertImageService;

    @PostMapping("/insert/images")
    public ResponseEventDto insertImages(InsertImageDto insertImageDto) {
        return null;
    }
}
