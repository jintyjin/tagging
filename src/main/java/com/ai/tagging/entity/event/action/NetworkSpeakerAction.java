package com.ai.tagging.entity.event.action;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NetworkSpeakerAction extends Action {

    @Column(name = "speaker_title")
    private String title;
}
