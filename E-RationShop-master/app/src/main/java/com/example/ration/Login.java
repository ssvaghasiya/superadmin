package com.example.ration;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ration.models.Auth_User;
import com.example.ration.models.Session;

import java.util.Date;

public class Login extends AppCompatActivity {

    Button button;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        button = findViewById(R.id.button_login);

        t1=findViewById(R.id.username);
        t2=findViewById(R.id.password);

        if(!new Session(getApplicationContext()).getUsername().equals(""))
        {
            Toast.makeText(getApplicationContext(),"i'm here",Toast.LENGTH_LONG).show();
            Intent i=new Intent(Login.this,MainActivity.class);
            i.putExtra("user",new Session(getApplicationContext()).getUsername());
            startActivity(i);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String uname=t1.getText().toString();
                final String pwd=t2.getText().toString();

                Call<Auth_User> call=RetrofitClient.getInstance().getApi().login(uname,pwd);
                call.enqueue(new Callback<Auth_User>() {
                    @Override
                    public void onResponse(Call<Auth_User> call, Response<Auth_User> response) {
                        if(response.body()!=null) {
//                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    Toast.makeText(getApplicationContext(),response.body().getExpiry().toString(),Toast.LENGTH_LONG).show();
                        String uname=new Session(getApplicationContext()).getUsername();
                        if(uname.equals(""))
                        {
                            new Session(getApplicationContext()).setUsername(response.body().getUser());
                            new Session(getApplicationContext()).setToken(response.body().getToken());
                        }

                        i.putExtra("user",response.body().getUser());
                            i.putExtra("expiry",response.body().getExpiry().toString());
                            startActivity(i);
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Wrong UserId or Password",Toast.LENGTH_LONG).show();
                        }
                        }

                    @Override
                    public void onFailure(Call<Auth_User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}
