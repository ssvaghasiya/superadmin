package com.example.ration.ui.ration_shop_details.shopindetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ration.R;
import com.example.ration.ui.ration_shop_details.AdapterForShopDetails;
import com.example.ration.ui.ration_shop_details.ModelForShopDetails;
import com.example.ration.ui.ration_shop_details.edit.EditItems;

import java.util.ArrayList;

public class ShopInDetails extends AppCompatActivity {
    RecyclerView dataList;
Button editbtn,btnup;
    ArrayList<ModelForShopIndetail> al;
    AdapterShopInDetail adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_in_details);



        btnup = findViewById(R.id.btnupdate);
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
            }
        });

        dataList = findViewById(R.id.recyclerViewforview);
        al = new ArrayList<>();
        al.add(new ModelForShopIndetail("Rice",22,24,32.3f));
        al.add(new ModelForShopIndetail("Rice",22,24,32.3f));



        adapter = new AdapterShopInDetail(getApplicationContext(),al);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
    }
}
