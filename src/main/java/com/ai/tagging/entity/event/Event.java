package com.ai.tagging.entity.event;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.event.image.Image;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event {

    @Id @GeneratedValue
    @Column(name = "event_id")
    private Long id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "event_time")
    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "event")
    private List<Box> boxes = new ArrayList<>();

    public Event(String name, LocalDateTime time, Device device, Image image) {
        this.name = name;
        this.time = time;
        this.device = device;
        this.image = image;
        if (image.getEvents().contains(this)) {
            image.getEvents().remove(this);
        }
        image.getEvents().add(this);
    }
}
