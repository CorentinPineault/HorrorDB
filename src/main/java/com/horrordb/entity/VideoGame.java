package com.horrordb.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="videogames")
public class VideoGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long game_id;

    private String title;

    private LocalDateTime releaseDate;

    private List<Person> devs;

    @ManyToMany
    @JoinTable(name="tag_games", joinColumns={@JoinColumn(name="game_id")}, inverseJoinColumns={@JoinColumn(name="tag_id")})
    private List<Tag> tags;

    
}
