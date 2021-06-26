package com.horrordb.entity;

import javax.persistence.*;
//import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name="webseries")
public class WebSeries extends WebElement {

    private LocalDate startDate;

    private LocalDate endDate;

    private int nbEpisodes;

    public WebSeries() {
    }

    public WebSeries(String name, String desc, LocalDate startDate, LocalDate endDate, String link, int nbEpisodes) {
        super(name, desc, link);
        this.startDate = startDate;
        this.endDate = endDate;
        this.nbEpisodes = nbEpisodes;
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

    public int getNbEpisodes() {
        return nbEpisodes;
    }

    public void setNbEpisodes(int num) {
        this.nbEpisodes = num;
    }
}
