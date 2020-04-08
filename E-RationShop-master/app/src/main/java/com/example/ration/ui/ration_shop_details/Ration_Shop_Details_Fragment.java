package com.example.ration.ui.ration_shop_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ration.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Ration_Shop_Details_Fragment extends Fragment {
    RecyclerView dataList;
    LinearLayout linearLayout,linearLayout1;
    ArrayList<ModelForShopDetails> al;
    AdapterForShopDetails adapter;
    Button checkOut;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ration_details, container, false);

        dataList = root.findViewById(R.id.recyclerforshopdetail);
        al = new ArrayList<>();
        al.add(new ModelForShopDetails("Harshit","Rajkot",22));



        adapter = new AdapterForShopDetails(getContext(),al);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        return root;
    }
}
