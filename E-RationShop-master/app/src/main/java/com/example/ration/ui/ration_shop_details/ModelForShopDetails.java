package com.example.ration.ui.ration_shop_details;

public class ModelForShopDetails {
    String S_Name,Rigion;
    int shop_Id;

    public ModelForShopDetails(String s_Name, String rigion, int shop_Id) {
        S_Name = s_Name;
        Rigion = rigion;
        this.shop_Id = shop_Id;
    }

    public String getS_Name() {
        return S_Name;
    }

    public void setS_Name(String s_Name) {
        S_Name = s_Name;
    }

    public String getRigion() {
        return Rigion;
    }

    public void setRigion(String rigion) {
        Rigion = rigion;
    }

    public int getShop_Id() {
        return shop_Id;
    }

    public void setShop_Id(int shop_Id) {
        this.shop_Id = shop_Id;
    }
}
