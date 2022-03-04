package com.ai.tagging.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseEventDto {

    private String status;
    private Integer insertQueueSize;
    private Integer responseQueueSize;
    private Integer postQueueSize;
}
