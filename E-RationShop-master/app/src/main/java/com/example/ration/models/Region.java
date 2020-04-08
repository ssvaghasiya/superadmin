package com.example.ration.models;

public class Region {

    int id;
    String region_name;
    int pin;

    public Region(int id, String region_name, int pin) {
        this.id = id;
        this.region_name = region_name;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
