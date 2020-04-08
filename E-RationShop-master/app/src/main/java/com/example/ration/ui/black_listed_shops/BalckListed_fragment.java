package com.example.ration.ui.black_listed_shops;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ration.R;
import com.example.ration.RetrofitClient;
import com.example.ration.models.Request_List;
import com.example.ration.models.Session;
import com.example.ration.ui.home.Adapterhome;
import com.example.ration.ui.home.Getallde;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BalckListed_fragment extends Fragment {

    RecyclerView recyclerView;
    MyListAdapter adapter;
    ArrayList<MyListData> items;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_blacklisted_shops, container, false);
        items= new ArrayList<>();

        Call<List<Request_List>> call= RetrofitClient.getInstance().getApi().getBlockedShops("JWT "+new Session(getContext()).getToken());
        call.enqueue(new Callback<List<Request_List>>() {
            @Override
            public void onResponse(Call<List<Request_List>> call, Response<List<Request_List>> response) {

                List<Request_List> list=response.body();
                for(Request_List l1:list)
                {
                    items.add(new MyListData(l1.getId(),l1.getRegion().getRegion_name()));
                }
                recyclerView = root.findViewById(R.id.recyclerViewforblack);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new MyListAdapter(getContext(),items,BalckListed_fragment.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Request_List>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
//
//        items.add(new MyListData(1,"Amd"));
//        items.add(new MyListData(3,"Amd"));
//        items.add(new MyListData(2,"Amd"));


        return root;
    }

    public void hey()
    {

//        Request_Fragment f2 = new Request_Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.detach(this);
        transaction.attach(this);
        transaction.commit();
        Toast.makeText(getContext(),"Jay Balaji Shop Blocked",Toast.LENGTH_LONG).show();
    }

}
