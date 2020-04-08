package com.example.ration.models;

import java.util.Date;

public class Auth_User {
    String token;
    String user;
    int role;
    boolean is_verified;
    Date expiry;

    public Auth_User(String token, String user, int role, boolean is_verified, Date expiry) {
        this.token = token;
        this.user = user;
        this.role = role;
        this.is_verified = is_verified;
        this.expiry = expiry;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return "Auth_User{" +
                "token='" + token + '\'' +
                ", user='" + user + '\'' +
                ", role=" + role +
                ", is_verified=" + is_verified +
                ", expiry='" + expiry + '\'' +
                '}';
    }
}
