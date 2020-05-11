package com.example.dbrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dbrecycler.DatabaseAsset.DatabaseAsset;
import com.example.dbrecycler.DetailsRead.DetailsReading;
import com.example.dbrecycler.Mode.Store;
import com.example.dbrecycler.RecyclerView.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewAdapter;
    androidx.recyclerview.widget.RecyclerView recyclerView;
    List<Store> stores;

    DatabaseAsset database;
    Button nextActivitybtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nextActivitybtn=findViewById(R.id.button);

        database=new DatabaseAsset(this);
        stores = database.getStore();

        recyclerViewAdapter=new RecyclerView(getBaseContext(),stores);

        recyclerView.setAdapter(recyclerViewAdapter);

        nextActivitybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button pressed", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });


        recyclerViewAdapter.setOnItemClickListener(new RecyclerView.ClickListener() {
            @Override
            public void OnItemClickListener(int position, View v) {
                if (position>=0){

                    Toast.makeText(MainActivity.this, "Position show"+position, Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(MainActivity.this, DetailsReading.class);
                    intent.putExtra("STORE", stores.get(position));
                    startActivity(intent);

                }


            }
        });
    }
}
