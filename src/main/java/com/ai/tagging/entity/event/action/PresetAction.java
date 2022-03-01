package com.ai.tagging.entity.event.action;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PresetAction extends Action {

    @Column(name = "preset_title")
    private String title;
}
