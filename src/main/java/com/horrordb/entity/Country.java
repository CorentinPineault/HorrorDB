package com.horrordb.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long country_id;

    private String name;

    private String continent;

    public Country() {

    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}