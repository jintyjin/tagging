package com.ai.tagging.entity.event.image;

import com.ai.tagging.entity.event.Event;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Image {

    @Id @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    @Column(name = "image_path")
    private String path;

    @Column(name = "image_thumb_path")
    private String thumbPath;

    private Integer width;

    private Integer height;

    @OneToMany(mappedBy = "image")
    private List<Event> events = new ArrayList<>();

    public Image(String path, String thumbPath, Integer width, Integer height) {
        this.path = path;
        this.thumbPath = thumbPath;
        this.width = width;
        this.height = height;
    }
}
