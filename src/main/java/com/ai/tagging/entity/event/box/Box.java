package com.ai.tagging.entity.event.box;

import com.ai.tagging.entity.event.Event;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   // SINGLE로 함(참조 시 하나의 테이블만 참조할 수 있도록)
@DiscriminatorColumn    // DTYPE을 클래스 명과 동일하게
@Getter
public abstract class Box {

    @Id @GeneratedValue
    @Column(name = "box_id")
    private Long id;

    private String model;

    private Double confidence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;

    public Box(String model, Double confidence, Event event) {
        this.model = model;
        this.confidence = confidence;
        this.event = event;
        if (event.getBoxes().contains(this)) {
            event.getBoxes().remove(this);
        }
        event.getBoxes().add(this);
    }
}
