package com.example.ration.ui.home;

public class Getallde {

    String itemname;
    int id;
    int quan,remain;
    float price;

    public Getallde(String itemname, int id, int quan, int remain, float price) {
        this.itemname = itemname;
        this.id = id;
        this.quan = quan;
        this.remain = remain;
        this.price = price;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
