package com.example.ration.ui.ration_shop_details.shopindetails;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ration.R;
import com.example.ration.ui.ration_shop_details.AdapterForShopDetails;
import com.example.ration.ui.ration_shop_details.ModelForShopDetails;
import com.example.ration.ui.ration_shop_details.edit.EditItems;

import java.util.ArrayList;

public class AdapterShopInDetail extends RecyclerView.Adapter<AdapterShopInDetail.ViewHolder> {


    ArrayList<ModelForShopIndetail> data;
    LayoutInflater inflater;
    Context ctx;
    public AdapterShopInDetail(Context ctx, ArrayList<ModelForShopIndetail> data)
    {

        this.data = data;
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;

    }

    @NonNull
    @Override
    public AdapterShopInDetail.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custon_shop_in_detail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterShopInDetail.ViewHolder holder, int position) {
        final ModelForShopIndetail obj =data.get(position);
        holder.vs_item_name.setText(obj.getV_Itemname());
        holder.vs_quantity.setText(String.valueOf(obj.getV_Quantity()));
        holder.vs_require.setText(String.valueOf(obj.getV_Require()));
        holder.vs_price.setText(String.valueOf(obj.getV_price()));

        holder.vs_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), EditItems.class);
                ctx.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView vs_item_name,vs_quantity,vs_require,vs_price;
        CardView vs_card;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
      vs_item_name = itemView.findViewById(R.id.v_item);
         vs_quantity =itemView.findViewById(R.id.v_quan);
           vs_require= itemView.findViewById(R.id.v_requirement);
           vs_price = itemView.findViewById(R.id.v_price);
           vs_card = itemView.findViewById(R.id.cardforview);
        }
    }
}

