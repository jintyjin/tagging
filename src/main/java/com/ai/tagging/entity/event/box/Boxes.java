package com.ai.tagging.entity.event.box;

import com.ai.tagging.entity.event.Event;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Boxes extends Box {

    private Integer xMin;
    private Integer xMax;
    private Integer yMin;
    private Integer yMax;

    public Boxes(String model, Double confidence, Event event, Integer xMin, Integer xMax, Integer yMin, Integer yMax) {
        super(model, confidence, event);
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }
}
