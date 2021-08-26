package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  RecyclerView mrecyclerview;
    private  FirebaseFirestore firebaseFirestore;
    ItemsAdapter adapter;
    ArrayList<Items> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerview = findViewById(R.id.recyclerview);
        datalist=new ArrayList<>();
        adapter=new ItemsAdapter(datalist);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerview.setAdapter(adapter);


        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Items").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            Items obj=d.toObject(Items.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }


}