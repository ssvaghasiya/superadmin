package com.example.ration.ui.black_listed_shops;

import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ration.R;
import com.example.ration.RetrofitClient;
import com.example.ration.models.Session;
import com.example.ration.ui.home.Adapterhome;
import com.example.ration.ui.home.Getallde;

import java.util.List;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private List<MyListData> data;
    BalckListed_fragment fragment;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_out,parent,false);
        return new ViewHolder(view);
    }
    MyListAdapter(Context context, List<MyListData> data,BalckListed_fragment fragment)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.fragment=fragment;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            final MyListData obj = data.get(position);
            holder.shopkeeperid.setText(String.valueOf(obj.getShpk_id()));
            holder.rname.setText(obj.getReg_name());
            holder.unblock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final  View v1=v;

                    Call<ResponseBody> call= RetrofitClient.getInstance().getApi().changePermission(obj.getShpk_id(),3,"JWT "+new Session(v1.getContext()).getToken());
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                            Toast.makeText(v1.getContext()," Jay Balaji Shop unblocked",Toast.LENGTH_LONG).show();
                        fragment.hey();
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(v1.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });




                }
            });


//        final MyListData myListData = listdata[position];
//        holder.textView.setText(listdata[position].getDescription());
//       // holder.imageView.setImageResource(listdata[position].getImgId());
//        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView shopkeeperid,rname;
        Button unblock;
        public ViewHolder(View itemView) {
            super(itemView);
            shopkeeperid = itemView.findViewById(R.id.shopkeeper_id);
            rname = itemView.findViewById(R.id.region_name);
            unblock=itemView.findViewById(R.id.block_btn);
        }
    }
}
