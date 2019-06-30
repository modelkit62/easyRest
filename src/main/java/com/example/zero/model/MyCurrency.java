package com.example.zero.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class MyCurrency {

    private String name;
    private String country;
    private Double value;

    public MyCurrency() {
    }

    public MyCurrency(String name, String country, Double value) {
        this.name = name;
        this.country = country;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Double getValue() {
        return value;
    }
}
