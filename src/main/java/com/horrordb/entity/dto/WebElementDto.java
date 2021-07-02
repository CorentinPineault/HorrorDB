package com.horrordb.entity.dto;

import com.googlecode.jmapper.annotations.JMap;

import java.util.ArrayList;
import java.util.List;

public class WebElementDto {

    @JMap
    private long web_id;

    @JMap
    private String name;

    @JMap
    private String description;

    @JMap
    private String link;

    @JMap
    private List<TagDto> tags;

    public WebElementDto() {
    }

    public WebElementDto(String name, String desc, String link) {
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

    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }
}
