package com.example.ration;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.ration.models.Session;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_request, R.id.nav_ration_shop_details,
                R.id.nav_stock_history, R.id.nav_blacklisted_shops,R.id.nav_providestock)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        Bundle b=getIntent().getExtras();
        String user_yo="";
        if(b!=null)
        {
            user_yo=b.getString("user");

        }

//        getIntent().getExtras().

//        Toast.makeText(MainActivity.this,"Welcome "+user_yo,Toast.LENGTH_LONG).show();

        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.INTERNET)== PackageManager.PERMISSION_GRANTED) {


            Toast.makeText(MainActivity.this,"Jay Balaji "+user_yo,Toast.LENGTH_LONG).show();


        }
        else{
            Toast.makeText(MainActivity.this,"No",Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.INTERNET},123);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this,"Successfully Logged Out",Toast.LENGTH_LONG).show();
                new Session(getApplicationContext()).setUsername("");
                new Session(getApplicationContext()).setToken("");
                startActivity(new Intent(MainActivity.this, Login.class));
                return true;
            case R.id.action_region:
                Intent i=new Intent(this,Show_New_Region.class);
                startActivity(i);
                return true;
            case R.id.action_rating:
                Intent i1=new Intent(this,Rating_Activity.class);
                startActivity(i1);
                return true;

        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length>0&&requestCode==123)
        {

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(MainActivity.this,"Yo You've granted the permission",Toast.LENGTH_LONG).show();

//                Intent i=new Intent(Intent.ACTION_CAMERA_BUTTON);
//                startActivityForResult(i,123);

            }
            else{
                Toast.makeText(MainActivity.this,"kindly accept the permission request",Toast.LENGTH_LONG).show();


            }


        }

    }
}
