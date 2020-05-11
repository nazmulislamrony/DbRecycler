package com.example.dbrecycler.DetailsRead;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.dbrecycler.DatabaseAsset.DatabaseAsset;
import com.example.dbrecycler.Mode.Store;
import com.example.dbrecycler.R;

import java.util.List;

public class DetailsReading extends AppCompatActivity {

    TextView title, body;
    private int id;
    Store store;

    int titleCont,bodyCont;

    DatabaseAsset database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_reading);

        title=findViewById(R.id.title_content);
        body=findViewById(R.id.bodyContent);

        store = getIntent().getParcelableExtra("STORE");

        Log.d("storeTag_0"," name and email: "+store.getName()+" :: "+store.getEmail());

//        title.setText(store.getName());
//        body.setText(store.getEmail());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            body.setText(Html.fromHtml(store.getEmail(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            body.setText(Html.fromHtml(store.getEmail()));
        }

        id=getIntent().getIntExtra("id",0);
    }
}
