package com.example.ecommerce;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<Category> categoryList;

    public CategoryAdapter(ArrayList<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category,parent,false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(holder.categoryimage.getContext()).load(categoryList.get(position).getImage()).into(holder.categoryimage);
        holder.categoryname.setText(categoryList.get(position).getName());

        holder.categoryimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.categoryimage.getContext() , CategoryInfoActivity.class);
                intent.putExtra("categoryname",categoryList.get(position).getName());
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                holder.categoryimage.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageButton categoryimage;
        private TextView categoryname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryimage = itemView.findViewById(R.id.category_Image);
            categoryname = itemView.findViewById(R.id.category_name);
        }
    }
}
