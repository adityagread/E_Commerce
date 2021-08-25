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
     Items item;
    private FirebaseFirestore firebaseFirestore;
    String Item_Name,Item_discription,Item_image;
    Long Item_Price;
    Long Item_quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        Item_info_image = findViewById(R.id.item_info_image);
        Item_info_Name = findViewById(R.id.item_info_name);
        Item_info_price = findViewById(R.id.item_info_price);
        Item_info_quantity = findViewById(R.id.item_info_quantity);
        Item_info_discription = findViewById(R.id.item_info_discription);


        firebaseFirestore = FirebaseFirestore.getInstance();
        CollectionReference applicationsRef = firebaseFirestore.collection("Items");
        DocumentReference applicationIdRef = applicationsRef.document("vwnizGiWzE9FhgAknfkJ");
        applicationIdRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Item_Name = document.getString("name");
                    Item_discription = (String) document.get("discription");
                    Item_image = (String) document.get("image");
                    Item_Price = (Long) document.get("price");
                    Item_quantity = (Long) document.get("quantity");

                }
            }
        });



        Item_info_Name.setText(Item_Name);
        Item_info_price.setText(Item_Price+"");
        Item_info_quantity.setText(Item_quantity+"");
        Item_info_discription.setText(Item_discription);
        Glide.with(ItemInfoActivity.this).load(Item_image).into(Item_info_image);

    }
}