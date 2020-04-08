package com.example.ration.ui.requests;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ration.MainActivity;
import com.example.ration.R;
import com.example.ration.RetrofitClient;
import com.example.ration.models.Request_List;
import com.example.ration.models.Session;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Request_List> data;

    Request_Fragment request_fragment;


    Adapter(Context context, List<Request_List> data,Request_Fragment request_fragment)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.request_fragment=request_fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       final Request_List obj = data.get(position);

       holder.rname.setText(obj.getRegion().getRegion_name());
       holder.pincode.setText(String.valueOf(obj.getRegion().getPin()));
       holder.name.setText(obj.getName());
       holder.qualification.setText(obj.getQualification().getName());
//        holder.shop_id.setText(String.valueOf(obj.getShop_id()));


//        String title1 = data.get(position);
//        holder.rname.setText(obj.getRegion_name());

//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final View v1=v;
//
//                int id=obj.getId();
//
//                Call<ResponseBody> call=RetrofitClient.getInstance().getApi().changePermission(id,2,"JWT "+new Session(v1.getContext()).getToken());
//                call.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
////                        Toast.makeText(v1.getContext()," Jay Balaji shop blocked",Toast.LENGTH_LONG).show();
//                        request_fragment.hey();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Toast.makeText(v1.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });


//        holder.confirm.setOnClickListener(this);


        holder.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View v1=v;
                Call<ResponseBody> call=RetrofitClient.getInstance().getApi().conf_request(obj.getId());
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(v1.getContext(),"Jay Balaji Request Accepted",Toast.LENGTH_LONG).show();
                        request_fragment.hey();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(v1.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });


//                request_fragment.hey(obj.getId());
//               final View v1=v;
//
//                int id=obj.getId();
//
//                Call<ResponseBody> call= RetrofitClient.getInstance().getApi().changePermission(id,1,"JWT "+new Session(v1.getContext()).getToken());
//                call.enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
////                        Toast.makeText(v1.getContext()," Jay Balaji Request Accepted",Toast.LENGTH_LONG).show();
//
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Toast.makeText(v1.getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
//                    }
//                });
//
//


            }
        });
//getFragmentManager()
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void update(){
        this.notifyDataSetChanged();
//        for (Object object : listOfObject){
//            arrayAdapter.add(object);
//        }
    }





    @Override
    public int getItemCount() {

        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView shop_id,region,id,rname,name,pincode,qualification;
        ImageButton delete,confirm;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            rname=itemView.findViewById(R.id.textView8);
            pincode = itemView.findViewById(R.id.shop_id);
            name=itemView.findViewById(R.id.textView9);
            qualification=itemView.findViewById(R.id.region_name);
            confirm=itemView.findViewById(R.id.confirm);
//            delete=itemView.findViewById(R.id.cancle);
//            shop_id = itemView.findViewById(R.id.textView9);
//            region = itemView.findViewById(R.id.textView10);
//
//            id = itemView.findViewById(R.id.textView11);
//            rname = itemView.findViewById(R.id.textView12);
//            delete = itemView.findViewById(R.id.delete);
//            confirm = itemView.findViewById(R.id.confirm);

        }
    }
}
