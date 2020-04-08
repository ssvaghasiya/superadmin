package com.example.ration.ui.ration_shop_details;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ration.R;
import com.example.ration.ui.ration_shop_details.shopindetails.ShopInDetails;

import java.util.ArrayList;

public class AdapterForShopDetails extends RecyclerView.Adapter<AdapterForShopDetails.ViewHolder> {


    ArrayList<ModelForShopDetails> data;
    LayoutInflater inflater;
    Context ctx;
    public AdapterForShopDetails(Context ctx, ArrayList<ModelForShopDetails> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;

    }

    @NonNull
    @Override
    public AdapterForShopDetails.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_for_ration_shop_details,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForShopDetails.ViewHolder holder, int position) {
        final ModelForShopDetails obj =data.get(position);
        holder.shop_name.setText(obj.getS_Name());
        holder.shop_ID.setText(String.valueOf(obj.getShop_Id()));
        holder.shop_rigion.setText(obj.getRigion());

        holder.btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ShopInDetails.class);
                ctx.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView shop_name,shop_rigion,shop_ID;
        Button btnview;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            shop_name = itemView.findViewById(R.id.sname);
            shop_ID =itemView.findViewById(R.id.rationshopid);
            shop_rigion = itemView.findViewById(R.id.shopregion);
            btnview = itemView.findViewById(R.id.btnshopviewindetail);
        }
    }
}
