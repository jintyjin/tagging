package com.ai.tagging.entity.event;

import com.ai.tagging.entity.device.Device;
import com.ai.tagging.entity.event.action.Action;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class EventAction {

    @Id @GeneratedValue
    @Column(name = "event_action_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private EventSource eventSource;

    @Enumerated(EnumType.STRING)
    private EventName eventName;

    @OneToMany(mappedBy = "eventAction")
    private List<Action> actions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

    public EventAction(EventSource eventSource, EventName eventName, Device device) {
        this.eventSource = eventSource;
        this.eventName = eventName;
        this.device = device;
    }
}
