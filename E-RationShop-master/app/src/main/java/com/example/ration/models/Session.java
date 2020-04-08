package com.example.ration.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class Session {

    private SharedPreferences preferences;

    public Session(Context context)
    {
        preferences= PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setUsername(String uname)
    {
        preferences.edit().putString("username",uname).commit();

    }
    public String getUsername()
    {
        String uname=preferences.getString("username","");
        return uname;
    }

    public void setToken(String token)
    {
        preferences.edit().putString("token",token).commit();

    }
    public String getToken()
    {
        String token=preferences.getString("token","");
        return token;
    }


//    public String setExpiry_token(Date expiry_token)
//    {
//        StringBuffer sb=new StringBuffer();
//        sb.append(expiry_token.getDate());
//        sb.append(" ");
////        sb.append(expiry_token.getMonth());
////        sb.append(" ");
////        sb.append(expiry_token.getYear());
//
//        preferences.edit().putString("expriy",sb.toString()).commit();
//        return sb.toString();
//
//    }
//    public Date getExpiry()
//    {
//        String x=preferences.getString("expiry","");
//        String[] s1=x.split(" ");
////        Toast.makeText(get)
//        Log.i("date",x);
//        Date d1=new Date(Integer.parseInt(s1[2]),Integer.parseInt(s1[1]),Integer.parseInt(s1[0]));
//        return d1;
//    }
//
//    public void set(String s)
//    {
//        preferences.edit().putString("ex",s).commit();
//    }
//    public String get()
//    {
//        String token=preferences.getString("ex","");
//        return token;
//    }

}
