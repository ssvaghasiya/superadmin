package com.example.ration.ui.requests;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ration.MainActivity;
import com.example.ration.R;
import com.example.ration.RetrofitClient;
import com.example.ration.models.Request_List;
import com.example.ration.models.Session;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Request_Fragment extends Fragment {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Get_idname> items;
    View root;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.request_fragment, container, false);
        items = new ArrayList<>();
    call_it();

        return root;


    }

    public void hey()
    {

//        Request_Fragment f2 = new Request_Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.detach(this);
        transaction.attach(this);
        transaction.commit();

    }


    public void call_it()
    {
        Call<List<Request_List>> call = RetrofitClient.getInstance().getApi().getRequests("JWT "+new Session(getContext()).getToken());

        call.enqueue(new Callback<List<Request_List>>() {
            @Override
            public void onResponse(Call<List<Request_List>> call, Response<List<Request_List>> response) {
                List<Request_List> list = response.body();

                ArrayList<Request_List> al=new ArrayList<>();

                for(Request_List l1:list)
                {
                    al.add(l1);
                }

                Toast.makeText(getContext(),list.toString(),Toast.LENGTH_LONG).show();
//                for (Request_List l1 : list) {
//                    items.add(new Get_idname(l1.getId(), l1.getRegion_id().getRegion_name()));
                    recyclerView = root.findViewById(R.id.recyclerview);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new Adapter(getContext(),al,Request_Fragment.this);
                    recyclerView.setAdapter(adapter);


            }





            @Override
            public void onFailure(Call<List<Request_List>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }



}
