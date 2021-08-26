package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.google.firebase.firestore.FirebaseFirestore;


import static android.content.ContentValues.TAG;

public class ItemInfoActivity extends AppCompatActivity {
    private ImageView Item_info_image;
    private TextView Item_info_Name,Item_info_price,Item_info_quantity,Item_info_discription;

    private FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        Item_info_image = findViewById(R.id.item_info_image);
        Item_info_Name = findViewById(R.id.item_info_name);
        Item_info_price = findViewById(R.id.item_info_price);
        Item_info_quantity = findViewById(R.id.item_info_quantity);
        Item_info_discription = findViewById(R.id.item_info_discription);

        Item_info_Name.setText(getIntent().getStringExtra("uname"));
        Item_info_price.setText(getIntent().getIntExtra("uprice",0)+ "");
        Item_info_quantity.setText(getIntent().getIntExtra("uquantity",0)+"");
        Item_info_discription.setText(getIntent().getStringExtra("udiscription"));
        Glide.with(ItemInfoActivity.this)
                .load(getIntent().getStringExtra("uimage"))
                .into(Item_info_image);
    }
}