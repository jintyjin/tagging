package com.ai.tagging.entity.event;

import lombok.Getter;

import java.util.List;

@Getter
public class Boxes extends Box {

    private List<Integer> xyxy;

    public Boxes(String model, Double confidence, Event event, List<Integer> xyxy) {
        super(model, confidence, event);
        this.xyxy = xyxy;
    }
}
