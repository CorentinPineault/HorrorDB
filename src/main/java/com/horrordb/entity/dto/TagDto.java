package com.horrordb.entity.dto;

import com.googlecode.jmapper.annotations.JMap;

import java.util.ArrayList;
import java.util.List;

public class TagDto {
    @JMap
    private long tag_id;

    @JMap
    private String name;

    @JMap
    private String description;

    @JMap
    private List<WebElementDto> webEntries;

    public TagDto(){

    }

    public TagDto(String name){
        this.name = name;
        this.webEntries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WebElementDto> getWebEntries() {
        return webEntries;
    }

    public void setWebEntries(List<WebElementDto> webEntries) {
        this.webEntries = webEntries;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}