package com.example.ration;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ration.models.Session;

public class Edit_Add_Item extends AppCompatActivity {

    int id,quan,remain;
    float price;
    String name;
    EditText e_name,e_price,e_quan,e_remain;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__add__item);

        setTitle("Update Details");

        e_name=findViewById(R.id.item_name_x1);
        e_remain=findViewById(R.id.item_remain);
        e_quan=findViewById(R.id.item_quan);
        e_price=findViewById(R.id.item_price);
        Bundle b=getIntent().getExtras();
        btn=findViewById(R.id.edit_btn_item);

//        String s=getIntent().getExtras().getString("key1");
        if(b!=null)
        {
            name=b.getString("name");
            id=b.getInt("id");
            quan=b.getInt("quan");
            remain=b.getInt("remain");
           price= b.getFloat("price");
        e_name.setText(name);
        e_quan.setText(String.valueOf(quan));
        e_price.setText(String.valueOf(price));
        e_remain.setText(String.valueOf(remain));

//            int id;


//            e1.setText(s);

//            Toast.makeText(Login.this,s+" is here",Toast.LENGTH_LONG).show();
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           final     View v1=v;
               Call<ResponseBody> call= RetrofitClient.getInstance().getApi().update_item(id,e_name.getText().toString(),Integer.parseInt(e_remain.getText().toString()),Integer.parseInt(e_quan.getText().toString()),Float.parseFloat(e_price.getText().toString()),"JWT "+new Session(v1.getContext()).getToken());
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(v1.getContext(),"Jay Ho Balaji gurudev",Toast.LENGTH_LONG).show();

                        Intent i=new Intent(Edit_Add_Item.this,MainActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(v1.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}
