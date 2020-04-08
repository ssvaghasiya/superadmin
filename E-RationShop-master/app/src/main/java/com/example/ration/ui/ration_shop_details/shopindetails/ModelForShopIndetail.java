package com.example.ration.ui.ration_shop_details.shopindetails;

public class ModelForShopIndetail {

    String V_Itemname;
    int V_Quantity;
    int V_Require;
    float V_price;

    public ModelForShopIndetail(String v_Itemname, int v_Quantity, int v_Require, float v_price) {
        V_Itemname = v_Itemname;
        V_Quantity = v_Quantity;
        V_Require = v_Require;
        V_price = v_price;
    }

    public String getV_Itemname() {
        return V_Itemname;
    }

    public void setV_Itemname(String v_Itemname) {
        V_Itemname = v_Itemname;
    }

    public int getV_Quantity() {
        return V_Quantity;
    }

    public void setV_Quantity(int v_Quantity) {
        V_Quantity = v_Quantity;
    }

    public int getV_Require() {
        return V_Require;
    }

    public void setV_Require(int v_Require) {
        V_Require = v_Require;
    }

    public float getV_price() {
        return V_price;
    }

    public void setV_price(float v_price) {
        V_price = v_price;
    }
}
