package com.ai.tagging.entity.event.action;

import com.ai.tagging.entity.event.EventAction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Action {

    @Id @GeneratedValue
    @Column(name = "action_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_action_id")
    private EventAction eventAction;

    public Action(EventAction eventAction) {
        this.eventAction = eventAction;
        if (eventAction.getActions().contains(this)) {
            eventAction.getActions().remove(this);
        }
        eventAction.getActions().add(this);
    }
}
