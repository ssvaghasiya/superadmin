package com.example.ration.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ration.MainActivity;
import com.example.ration.R;
import com.example.ration.Show_New_Region;
import com.example.ration.models.New_Region;
import com.example.ration.ui.home.Adapterhome;
import com.example.ration.ui.home.Getallde;
import com.example.ration.ui.home.HomeFragment;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRegion extends RecyclerView.Adapter<AdapterRegion.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<New_Region> data;
    private Show_New_Region show_new_region;

    public AdapterRegion(Context context, List<New_Region> data,Show_New_Region show_new_region)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.show_new_region=show_new_region;
//        this.homeFragment=homeFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View view = layoutInflater.inflate(R.layout.new_regions_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

     final  New_Region region=data.get(position);
        holder.t1.setText(region.getRegion_name());
        holder.t2.setText(String.valueOf(region.getPin()));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_new_region.hey(region.getId());
//                Toast.makeTex
            }
        });

    }


    @Override
    public int getItemCount() {
        return this.data.size();
//        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView t1,t2;
        ImageButton btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.new_region_name);
            t2 = itemView.findViewById(R.id.new_region_pincode);
//            remain = itemView.findViewById(R.id.remain_home);
            btn=itemView.findViewById(R.id.confirm);
        }
    }
}
