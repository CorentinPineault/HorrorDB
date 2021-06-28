package com.horrordb.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="webelements")
public class WebElement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long web_id;

    private String name;

    @Size(min = 0, max = 1280)
    @Column(length = 1280)
    private String description;

    private String link;

    @ManyToMany
    @JoinTable(name="tag_webelements", joinColumns={@JoinColumn(name="web_id")}, inverseJoinColumns={@JoinColumn(name="tag_id")})
    private List<Tag> tags;

    public WebElement() {
    }

    public WebElement(String name, String desc, String link) {
        this.name = name;
        this.description = desc;
        this.link = link;
        this.tags = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
