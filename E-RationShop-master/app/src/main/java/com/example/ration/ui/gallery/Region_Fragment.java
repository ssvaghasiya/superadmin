package com.example.ration.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ration.R;
import com.example.ration.RetrofitClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Region_Fragment extends Fragment {

    EditText e1,e2;
    CheckBox c1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_region, container, false);

        e1=root.findViewById(R.id.edit_region);
        e2=root.findViewById(R.id.edit_region_pin);
        c1=root.findViewById(R.id.check_rgn);

       Button btn= root.findViewById(R.id.btn_submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final View v1=v;
                String s=e1.getText().toString();
                int pin=Integer.parseInt(e2.getText().toString());
                boolean is=c1.isChecked();

                Call<ResponseBody> call= RetrofitClient.getInstance().getApi().add_region(s,pin,is);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.body()!=null)
                        {
                            Toast.makeText(v1.getContext(),"Jay Balaji Region added",Toast.LENGTH_LONG).show();
                            e1.setText("");
                            e2.setText("");
                            c1.setChecked(false);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(v1.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


        return root;
    }



}
