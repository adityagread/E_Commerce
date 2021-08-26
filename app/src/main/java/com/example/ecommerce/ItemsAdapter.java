package com.example.ecommerce;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private ArrayList<Items> itemsList;

    public ItemsAdapter(ArrayList<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(holder.itemImage.getContext()).load(itemsList.get(position).getImage()).into(holder.itemImage);
        holder.itemName.setText(itemsList.get(position).getName());
        holder.itemPrice.setText(itemsList.get(position).getPrice()+"");

        holder.itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemImage.getContext() , ItemInfoActivity.class);
                intent.putExtra("uname",itemsList.get(position).getName());
                intent.putExtra("udiscription",itemsList.get(position).getDiscription());
                intent.putExtra("uprice",itemsList.get(position).getPrice());
                intent.putExtra("uquantity",itemsList.get(position).getQuantity());
                intent.putExtra("uimage",itemsList.get(position).getImage());
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemImage.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        
        public ImageButton itemImage;
        public TextView itemName, itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_Image);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
        }

        @Override
        public void onClick(View v) {


        }
    }
}
