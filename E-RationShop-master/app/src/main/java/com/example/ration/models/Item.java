package com.example.ration.models;

public class Item {

    int id;
    String item_name;
    int quantity;
    int remaining;
    float price;
    int History_id;

    public Item(int id, String item_name, int quantity, int remaining, float price, int history_id) {
        this.id = id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.remaining = remaining;
        this.price = price;
        History_id = history_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getHistory_id() {
        return History_id;
    }

    public void setHistory_id(int history_id) {
        History_id = history_id;
    }
}
