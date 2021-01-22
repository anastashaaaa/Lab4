package com.company;

public class Ticket {
    private String country;
    private String date;
    private String city;
    private int people_amount;

    public int getPeople_amount() {
        return people_amount;
    }

    public void setPeople_amount(int people_amount) {
        this.people_amount = people_amount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
