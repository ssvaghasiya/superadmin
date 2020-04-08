package com.example.ration.models;

public class ShopKeeper {

    int id;
    boolean verified;
    String contact;
    int auth_id;
    int role_id;

    public ShopKeeper(int id, boolean verified, String contact, int auth_id, int role_id) {
        this.id = id;
        this.verified = verified;
        this.contact = contact;
        this.auth_id = auth_id;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(int auth_id) {
        this.auth_id = auth_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
