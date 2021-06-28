package com.horrordb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tag_id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "tags")
    private List<WebElement> webEntries;

    public Tag(){

    }

    public Tag(String name){
        this.name = name;
        this.webEntries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WebElement> getWebEntries() {
        return webEntries;
    }

    public void setWebEntries(List<WebElement> webEntries) {
        this.webEntries = webEntries;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}