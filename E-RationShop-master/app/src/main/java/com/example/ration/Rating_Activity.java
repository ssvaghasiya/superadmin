package com.example.ration;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rating_Activity extends AppCompatActivity {

    RatingBar r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_);
        r1=findViewById(R.id.rating_1);
        r2=findViewById(R.id.rating_2);
        r3=findViewById(R.id.rating_3);
        r4=findViewById(R.id.rating_4);
//
//        r1.setMax(5);
//        r2.setMax(5);
//        r3.setMax(5);        r4.setMax(5);

        Button btn=findViewById(R.id.rating_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float res=r1.getRating()+r2.getRating()+r3.getRating()+r4.getRating();
                res/=4;

                Call<ResponseBody> call=RetrofitClient.getInstance().getApi().update_rating(1,res);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(getApplicationContext(),"Jay Baljai",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


//                findViewById(R.id.action_rating).setEnabled(false);

//                r1.setRating(0);
//                r1.setRating(0);



            }
        });





    }
}
