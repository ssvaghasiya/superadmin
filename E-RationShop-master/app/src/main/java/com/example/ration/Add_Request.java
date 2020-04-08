package com.example.ration;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Add_Request extends AppCompatActivity {

    EditText t1,t2,t3,t4;

    Spinner sp;
    int id;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__request);

        id=0;

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            id=bundle.getInt("id");
        }

        t1=findViewById(R.id.name_add);
        t2=findViewById(R.id.address_add);
        t3=findViewById(R.id.phn_add);
        t4=findViewById(R.id.email_add);
        btn=findViewById(R.id.btn_add);
        sp=findViewById(R.id.spinner_qual);
        List<String> qual=new ArrayList<>();
        qual.add("Master Degree");
        qual.add("Bachelor's Degree");
        qual.add("12th Pass");
        qual.add("10th Pass");
        qual.add("Below 10th");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,qual);
        sp.setAdapter(adapter1);

//        sp.getSelectedItemPosition();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View v1=v;
                int x=sp.getSelectedItemPosition();

                Call<ResponseBody> call=RetrofitClient.getInstance().getApi().Add_Request(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),false,x+1,id);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(v1.getContext(),"Jay balaji",Toast.LENGTH_LONG).show();
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
