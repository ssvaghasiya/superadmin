package com.example.ration.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ration.R;
import com.example.ration.ui.requests.Adapter;
import com.example.ration.ui.requests.Get_idname;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapterhome extends RecyclerView.Adapter<Adapterhome.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Getallde> data;
    HomeFragment homeFragment;

    Adapterhome(Context context, List<Getallde> data,HomeFragment homeFragment)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.homeFragment=homeFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.month_year,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
                final Getallde obj = data.get(position);
                holder.item.setText(obj.getItemname());
                holder.quantity.setText(String.valueOf(obj.getQuan()));
                holder.remain.setText(String.valueOf(obj.getRemain()));
                holder.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(v.getContext(),obj.getItemname(),Toast.LENGTH_LONG).show();
                        homeFragment.redirect(obj.getItemname(),obj.getId(),obj.getQuan(),obj.getRemain(),obj.getPrice());
                    }
                });
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView item, quantity, remain;
        Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item_home);
            quantity = itemView.findViewById(R.id.quntity_home);
            remain = itemView.findViewById(R.id.remain_home);
            btn=itemView.findViewById(R.id.edit_btn);
        }
    }
}
