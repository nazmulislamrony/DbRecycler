package com.example.dbrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.dbrecycler.DatabaseAsset.DatabaseAsset;
import com.example.dbrecycler.Mode.SecondStore;
import com.example.dbrecycler.Mode.Store;
import com.example.dbrecycler.RecyclerView.RecyclerView;
import com.example.dbrecycler.RecyclerView.SecondRecyclerAdapter;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    SecondRecyclerAdapter recyclerViewAdapter;
    androidx.recyclerview.widget.RecyclerView recyclerView;
    List<SecondStore> secondStores;
    DatabaseAsset database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database=new DatabaseAsset(this);
        secondStores = database.getSecondStore();

        recyclerViewAdapter=new SecondRecyclerAdapter(getBaseContext(),secondStores);

        recyclerView.setAdapter(recyclerViewAdapter);

        // is

    }
}
