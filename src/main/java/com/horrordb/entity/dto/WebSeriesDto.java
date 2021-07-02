package com.horrordb.entity.dto;

import com.googlecode.jmapper.annotations.JMap;

import java.time.LocalDate;

public class WebSeriesDto extends WebElementDto {

    @JMap
    private LocalDate startDate;

    @JMap
    private LocalDate endDate;

    @JMap
    private int nbEpisodes;

    public WebSeriesDto() {
    }

    public WebSeriesDto(String name, String desc, LocalDate startDate, LocalDate endDate, String link, int nbEpisodes) {
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
