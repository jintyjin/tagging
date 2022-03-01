package com.ai.tagging.entity.event;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.event.box.Box;
import com.ai.tagging.entity.event.image.Image;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Event {

    @Id @GeneratedValue
    @Column(name = "event_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private EventName eventName;

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

    public Event(EventName eventName, LocalDateTime time, Device device, Image image) {
        this.eventName = eventName;
        this.time = time;
        this.device = device;
        this.image = image;
        if (image.getEvents().contains(this)) {
            image.getEvents().remove(this);
        }
        image.getEvents().add(this);
    }
}
