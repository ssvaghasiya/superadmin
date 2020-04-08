package com.example.ration.models;

public class New_Region {

    int id;
    String region_name;
    int pin;
    boolean is_open;

    public New_Region(int id, String region_name, int pin, boolean is_open) {
        this.id = id;
        this.region_name = region_name;
        this.pin = pin;
        this.is_open = is_open;
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

    public boolean isIs_open() {
        return is_open;
    }

    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
    }
}
