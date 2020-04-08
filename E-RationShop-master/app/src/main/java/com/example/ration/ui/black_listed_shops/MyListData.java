package com.example.ration.ui.black_listed_shops;

public class MyListData {

    int shpk_id;
    String reg_name;

    public MyListData(int shpk_id, String reg_name) {
        this.shpk_id = shpk_id;
        this.reg_name = reg_name;
    }

    public int getShpk_id() {
        return shpk_id;
    }

    public void setShpk_id(int shpk_id) {
        this.shpk_id = shpk_id;
    }

    public String getReg_name() {
        return reg_name;
    }

    public void setReg_name(String reg_name) {
        this.reg_name = reg_name;
    }

    //    private String description;
//   // private int imgId;
//    public MyListData(String description, int imgId) {
//        this.description = description;
//        //this.imgId = imgId;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
////    public int getImgId() {
////        return imgId;
////    }
////    public void setImgId(int imgId) {
////        this.imgId = imgId;
////    }
}
