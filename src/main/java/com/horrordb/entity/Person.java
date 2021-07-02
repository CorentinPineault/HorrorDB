package com.horrordb.entity;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long person_id;

    private String firstname;

    private String lastname;

    private String nickname;

    private LocalDate dob;

    private LocalDate dod;

    private Country country;

    public Person() {
    }

    public Person(String firstname, String lastname, String nickname, LocalDate dob, LocalDate dod, Country country) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.dob = dob;
        this.dod = dod;
        this.country = country;
    }
}
