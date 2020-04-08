package com.example.ration.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.ration.Edit_Add_Item;
import com.example.ration.Login;
import com.example.ration.R;
import com.example.ration.RetrofitClient;
import com.example.ration.models.Item;
import com.example.ration.models.Session;
import com.example.ration.ui.black_listed_shops.MyListAdapter;
import com.example.ration.ui.requests.Adapter;
import com.example.ration.ui.requests.Get_idname;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

//    private HomeViewModel homeViewModel;
    RecyclerView recyclerView;
    Adapterhome adapter;
    ArrayList<Getallde> items;
    Spinner sp1,sp2;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
      // TextView t1=root.findViewById(R.id.textView_home);
       StringBuffer sb=new StringBuffer();
//       sb.append(new Session(getContext()).get()+"\n");
//       sb.append(new Session(getContext()).getExpiry().toString());
//       t1.setText(sb.toString());
//       t1.setText();
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        items.add(new Getallde("rise",23,12));
         sp1=root.findViewById(R.id.spinner);
        sp2=root.findViewById(R.id.spinner2);
//        String[] months={"1","2","3","4","5","6","7","8","9","10","11","12"};
        List<String> months=new ArrayList<>();
        months.add("1");months.add("2");months.add("3");months.add("4");
        months.add("5");months.add("6");months.add("7");months.add("8");
        months.add("9");months.add("10");months.add("11");months.add("12");

        List<String> yrs=new ArrayList<>();
        yrs.add("2020");
        yrs.add("2019");
        yrs.add("2018");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,months);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,yrs);

        sp1.setAdapter(adapter1);
        sp2.setAdapter(adapter2);

        call_it(1,2020);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s= sp1.getSelectedItem().toString();
                String s1= sp2.getSelectedItem().toString();
//
                call_it(Integer.parseInt(s),Integer.parseInt(s1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s= sp1.getSelectedItem().toString();
                String s1= sp2.getSelectedItem().toString();
//
                call_it(Integer.parseInt(s),Integer.parseInt(s1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//        sp1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//             String s= sp1.getSelectedItem().toString();
//                String s1= sp2.getSelectedItem().toString();
//
//                call_it(Integer.parseInt(s),Integer.parseInt(s1));
//            }
//        });
//        sp2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String s= sp1.getSelectedItem().toString();
//                String s1= sp2.getSelectedItem().toString();
//
//                call_it(Integer.parseInt(s),Integer.parseInt(s1));
//            }
//        });
//



        return root;
    }

    public void redirect(String name,int id,int quan,int remain,float price)
    {
        Intent i=new Intent(getContext(), Edit_Add_Item.class);
        i.putExtra("name",name);
        i.putExtra("id",id);
        i.putExtra("quan",quan);
        i.putExtra("remain",remain);
        i.putExtra("price",price);
        startActivity(i);
    }

    public void call_it(int mo,int yr)
    {
        Call<List<Item>> call= RetrofitClient.getInstance().getApi().getIemDetails(mo,yr,"JWT "+new Session(getContext()).getToken());
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {


                items=new ArrayList<>();

                List<Item> list=response.body();
                if(list!=null)
                {
                    for(Item i1:list)
                    {
                        items.add(new Getallde(i1.getItem_name(),i1.getId(),i1.getQuantity(),i1.getRemaining(),i1.getPrice()));
                    }
                }

//        String[] year={"2020","2019","2018"};new

                recyclerView = root.findViewById(R.id.recyclviewforhome);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new Adapterhome(getContext(),items,HomeFragment.this);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });

    }










}