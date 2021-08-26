package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

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


       /* firebaseFirestore = FirebaseFirestore.getInstance();
        CollectionReference applicationsRef = firebaseFirestore.collection("Items");
        DocumentReference applicationIdRef = applicationsRef.document("vwnizGiWzE9FhgAknfkJ");
        applicationIdRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Item_info_Name.setText(document.getString("name"));
                    Item_info_price.setText(document.get("price")+"");
                    Item_info_quantity.setText(document.get("quantity")+"");
                    Item_info_discription.setText(document.getString("discription"));
                    Glide.with(ItemInfoActivity.this).load(document.getString("image")).into(Item_info_image);

                }
            }
        });*/






    }
}