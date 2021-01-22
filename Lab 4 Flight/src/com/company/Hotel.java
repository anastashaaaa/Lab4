package com.company;

public class Hotel
{
    private String hotelsName;
    private String city;
    private int amountStars;
    private int price;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHotelsName() {
        return hotelsName;
    }

    public void setHotelsName(String hotelsName) {
        this.hotelsName = hotelsName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAmountStars() {
        return amountStars;
    }

    public void setAmountStars(int amountStars) {
        this.amountStars = amountStars;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
