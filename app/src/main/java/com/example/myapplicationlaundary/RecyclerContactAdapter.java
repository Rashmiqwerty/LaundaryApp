package com.example.myapplicationlaundary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerContactAdapter<view> extends RecyclerView.Adapter<RecyclerContactAdapter.viewHolder> {
    Context context;
    List<ContactModel> shopList;

    public RecyclerContactAdapter(Context context, List<ContactModel> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @NonNull
    @Override
    public RecyclerContactAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v=  LayoutInflater.from(context).inflate(R.layout.dukancontact_row,parent,false);
      viewHolder viewHolder=new viewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerContactAdapter.viewHolder holder, int position) {
//kaha pa ky input dena h ye batata h ye
        Picasso.get().load(shopList.get(position).shopImage).centerCrop().fit().into(holder.imgdukan);
        holder.textShopName.setText(shopList.get(position).shopName);
        holder.txtName.setText(shopList.get(position).shopOwnerName);
        holder.txtNumber.setText(shopList.get(position).shopNumber);
        holder.textShopLocation.setText(shopList.get(position).shopAddress);
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtNumber,textShopName,textShopLocation;
        ImageView imgdukan;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgdukan=itemView.findViewById(R.id.image);
            textShopLocation=itemView.findViewById(R.id.textShopLocation);
            textShopName=itemView.findViewById(R.id.textShopName);
            txtName=itemView.findViewById(R.id.textOwnerName);
            txtNumber=itemView.findViewById(R.id.textShopNumber);
        }
    }
}
