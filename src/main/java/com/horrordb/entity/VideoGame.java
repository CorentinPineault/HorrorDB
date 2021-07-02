package com.horrordb.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="videogames")
public class VideoGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long game_id;

    private String name;

    private LocalDateTime releaseDate;

    private List<Tag> tags;
}
