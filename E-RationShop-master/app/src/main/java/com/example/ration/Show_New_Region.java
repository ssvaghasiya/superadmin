package com.example.ration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ration.models.New_Region;
import com.example.ration.ui.AdapterRegion;
import com.example.ration.ui.home.Adapterhome;
import com.example.ration.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class Show_New_Region extends AppCompatActivity {

    AdapterRegion adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__new__region);
        setTitle("Show Regions");

//        ArrayList<New_Region> al=new ArrayList<>();

//        al.add(new New_Region(1,"Rajkot",360083,true));
//        al.add(new New_Region(1,"Rajkot",360083,true));
        Call<List<New_Region>> call=RetrofitClient.getInstance().getApi().get_new_regions();

        call.enqueue(new Callback<List<New_Region>>() {
            @Override
            public void onResponse(Call<List<New_Region>> call, Response<List<New_Region>> response) {

                List<New_Region> list=response.body();


                recyclerView = findViewById(R.id.recyclerViewforblack);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new AdapterRegion(getApplicationContext(),list,Show_New_Region.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<New_Region>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });



    }

    public void hey(int id)
    {
        Intent i=new Intent(getApplicationContext(),Add_Request.class);
        i.putExtra("id",id);
        startActivity(i);
    }

}
