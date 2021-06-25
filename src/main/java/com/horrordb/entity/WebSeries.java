package com.horrordb.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name="webseries")
public class WebSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Size(min = 0, max = 1280)
    @Column(length = 1280)
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String link;

    public WebSeries() {
    }

    public WebSeries(String name, String desc, LocalDate startDate, LocalDate endDate, String link) {
        this.name = name;
        this.description = desc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.link = link;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
