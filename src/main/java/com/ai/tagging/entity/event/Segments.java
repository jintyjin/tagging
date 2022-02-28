package com.ai.tagging.entity.event;

import lombok.Getter;

import java.util.List;

@Getter
public class Segments extends Box {

    private List<List<Integer>> vector;

    public Segments(String model, Double confidence, Event event, List<List<Integer>> vector) {
        super(model, confidence, event);
        this.vector = vector;
    }
}
