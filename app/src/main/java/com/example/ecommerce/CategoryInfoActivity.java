package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class CategoryInfoActivity extends AppCompatActivity {

    private RecyclerView mrecyclerview;
    private FirebaseFirestore firebaseFirestore;
    ItemsAdapter adapter;
    ArrayList<Items> datalist;
    String CategoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_info);

        mrecyclerview = findViewById(R.id.recyclerviewitem);
        datalist=new ArrayList<>();
        adapter=new ItemsAdapter(datalist);
        mrecyclerview.setLayoutManager(new GridLayoutManager(CategoryInfoActivity.this,2));
        mrecyclerview.setAdapter(adapter);

        CategoryName = getIntent().getStringExtra("categoryname");

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Items").whereEqualTo("category",CategoryName).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        Log.d(TAG, "onSuccess: good");
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            Log.d(TAG, "onSuccess: very good");
                            Items obj=d.toObject(Items.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });

    }
}