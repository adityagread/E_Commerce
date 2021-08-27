package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  RecyclerView mrecyclerview;
    private  FirebaseFirestore firebaseFirestore;
    CategoryAdapter adapter;
    ArrayList<Category> datalist;
    EditText EdittextSearch;
    ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mrecyclerview = findViewById(R.id.recyclerviewcategory);
        datalist=new ArrayList<>();
        adapter=new CategoryAdapter(datalist);
        mrecyclerview.setLayoutManager(new GridLayoutManager(this,3));
        mrecyclerview.setAdapter(adapter);
        EdittextSearch = findViewById(R.id.search);
        EdittextSearch.setFocusableInTouchMode(true);


        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Category").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            Category obj=d.toObject(Category.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuitem, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        EdittextSearch.setFocusable(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EdittextSearch.clearFocus();
    }
}