package com.example.myapplicationlaundary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerOrderListAdapter extends RecyclerView.Adapter<RecyclerOrderListAdapter.viewHolder> {
    Context context;
    List<OrderListModel>  ItemList;

    public RecyclerOrderListAdapter() {
        this.context = context;
        this.ItemList = ItemList;
    }
    @NonNull
    @Override
    public RecyclerOrderListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=  LayoutInflater.from(context).inflate(R.layout.order_items_shop_item_list_ka,parent,false);
       viewHolder viewHolder=new viewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerOrderListAdapter.viewHolder holder, int position) {
        holder.ItemName.setText(ItemList.get(position).getItemName());
        holder.Itemprice.setText(ItemList.get(position).getItemprice());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView ItemName,Itemprice;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ItemName=itemView.findViewById(R.id.ItemName);
            Itemprice=itemView.findViewById(R.id.Itemprice);
        }
    }
}
