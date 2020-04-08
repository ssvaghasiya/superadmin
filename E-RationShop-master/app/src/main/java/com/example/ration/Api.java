package com.example.ration;

import com.example.ration.models.Auth_User;
import com.example.ration.models.Item;
import com.example.ration.models.New_Region;
import com.example.ration.models.Request_List;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

//    @Headers({"Authorization:JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJ1c2VybmFtZSI6ImhwQGdtYWlsLmNvbSIsImV4cCI6MTU4NDI5NDk0NiwiZW1haWwiOiJocEBnbWFpbC5jb20iLCJvcmlnX2lhdCI6MTU4MzY5MDE0Nn0.ysPEB3BBSpX5ulskZrX7_mnhVnw-M4trHxctc1HzU5g"})
    @GET("view-request/")
    Call<List<Request_List>> getRequests(@Header("Authorization")String u1);

//    @Headers({"Authorization:JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJ1c2VybmFtZSI6ImhwQGdtYWlsLmNvbSIsImV4cCI6MTU4NDI5NDk0NiwiZW1haWwiOiJocEBnbWFpbC5jb20iLCJvcmlnX2lhdCI6MTU4MzY5MDE0Nn0.ysPEB3BBSpX5ulskZrX7_mnhVnw-M4trHxctc1HzU5g"})
    @GET("update-shop-permission/")
    Call<ResponseBody> changePermission(@Query("id")int id,@Query("req")int req, @Header("Authorization")String u1);

//    @Headers({"Authorization:JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJ1c2VybmFtZSI6ImhwQGdtYWlsLmNvbSIsImV4cCI6MTU4NDI5NDk0NiwiZW1haWwiOiJocEBnbWFpbC5jb20iLCJvcmlnX2lhdCI6MTU4MzY5MDE0Nn0.ysPEB3BBSpX5ulskZrX7_mnhVnw-M4trHxctc1HzU5g"})
    @GET("blocked-shops/")
    Call<List<Request_List>> getBlockedShops(@Header("Authorization")String u1);

//    @Headers({"Authorization:JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJ1c2VybmFtZSI6ImhwQGdtYWlsLmNvbSIsImV4cCI6MTU4NDI5NDk0NiwiZW1haWwiOiJocEBnbWFpbC5jb20iLCJvcmlnX2lhdCI6MTU4MzY5MDE0Nn0.ysPEB3BBSpX5ulskZrX7_mnhVnw-M4trHxctc1HzU5g"})
//    @GET("list-item-admin/")
//    Call<List<Item>> getIemDetails(@Query("month")int m, @Query("year")int year);

//    @Headers({"Authorization:JWT "})
    @GET("list-item-admin/")
    Call<List<Item>> getIemDetails(@Query("month")int m, @Query("year")int year, @Header("Authorization")String u1);


    @FormUrlEncoded
    @POST("api/jwt/")
    Call<Auth_User> login(@Field("username") String username,@Field("password")String password);

//    @Headers({"Authorization:JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJ1c2VybmFtZSI6ImhwQGdtYWlsLmNvbSIsImV4cCI6MTU4NDI5NDk0NiwiZW1haWwiOiJocEBnbWFpbC5jb20iLCJvcmlnX2lhdCI6MTU4MzY5MDE0Nn0.ysPEB3BBSpX5ulskZrX7_mnhVnw-M4trHxctc1HzU5g"})
    @FormUrlEncoded
    @PUT("update-item-admin/{id}")
    Call<ResponseBody> update_item(@Path("id") int id,@Field("item_name")String name,@Field("remaining")int remain,@Field("quantity")int quan,@Field("price")float price, @Header("Authorization")String u1);

    @FormUrlEncoded
    @POST("new-region/")
    Call<ResponseBody> add_region(@Field("region_name") String r_name,@Field("pin")int pin,@Field("is_open") boolean open);

//    @For/mUrlEncoded
    @POST("confirm-request/")
    Call<ResponseBody> conf_request(@Query("id") int id);

    @GET("view-new-recruit/")
    Call<List<New_Region>> get_new_regions();


    @FormUrlEncoded
    @POST("create-request/")
    Call<ResponseBody> Add_Request(@Field("name")String name,@Field("address")String add,@Field("contact_no")String cont,@Field("email")String mail,@Field("is_reviewed")boolean is_review,@Field("qualification")int qual,@Field("region_id")int r_d);

//    @FormUrlEncoded
    @PUT("update-rating/")
    Call<ResponseBody> update_rating(@Query("id")int id,@Query("rating")float rating);


}
