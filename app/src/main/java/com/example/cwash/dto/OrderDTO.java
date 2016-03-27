package com.example.cwash.dto;

public class OrderDTO {

    private String title_car;
    private String title_time;
    private String title_number;
    private String title_price;

    public OrderDTO(String title_car, String title_time, String title_number, String title_price) {
        this.title_car = title_car;
        this.title_time = title_time;
        this.title_number = title_number;
        this.title_price = title_price;
    }

    public String getTitle_car() {
        return title_car;
    }

    public void setTitle_car(String title_car) {
        this.title_car = title_car;
    }

    public String getTitle_time() {
        return title_time;
    }

    public void setTitle_time(String title_time) {
        this.title_time = title_time;
    }

    public String getTitle_number() {
        return title_number;
    }

    public void setTitle_number(String title_number) {
        this.title_number = title_number;
    }

    public String getTitle_price() {
        return title_price;
    }

    public void setTitle_price(String title_price) {
        this.title_price = title_price;
    }
}
