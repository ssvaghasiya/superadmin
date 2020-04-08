package com.example.ration.models;

import com.google.gson.annotations.SerializedName;

public class Request_List {

    int id;
    @SerializedName("region_id")
    New_Region region;
    Qualification qualification;
    String name;
    String address;
    String contact_no;
    String email;
    boolean is_reviewed;

    public Request_List(int id, New_Region region, Qualification qualification, String name, String address, String contact_no, String email, boolean is_reviewed) {
        this.id = id;
        this.region = region;
        this.qualification = qualification;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.email = email;
        this.is_reviewed = is_reviewed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public New_Region getRegion() {
        return region;
    }

    public void setRegion(New_Region region) {
        this.region = region;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_reviewed() {
        return is_reviewed;
    }

    public void setIs_reviewed(boolean is_reviewed) {
        this.is_reviewed = is_reviewed;
    }

    @Override
    public String toString() {
        return "Request_List{" +
                "id=" + id +
                ", region=" + region +
                ", qualification=" + qualification +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact_no='" + contact_no + '\'' +
                ", email='" + email + '\'' +
                ", is_reviewed=" + is_reviewed +
                '}';
    }
}
