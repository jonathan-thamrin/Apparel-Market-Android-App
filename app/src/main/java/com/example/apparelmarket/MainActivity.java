package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String ITEM_DETAIL_KEY = "item";

    // From activity_main.xml
    CardView cvCategory1, cvCategory2, cvCategory3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialising ListView from activity_main.xml
        cvCategory1 = (CardView) findViewById(R.id.cvCategory1);
        cvCategory2 = (CardView) findViewById(R.id.cvCategory2);
        cvCategory3 = (CardView) findViewById(R.id.cvCategory3);

        setupCategorySelectedListener();
    }

    public void setupCategorySelectedListener() {
        // Sets OnClick Listener for ListView
        cvCategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shirtsIntent = new Intent(MainActivity.this, ListActivity.class);
                shirtsIntent.putExtra(ITEM_DETAIL_KEY, ApparelProvider.getShirtItems());
                startActivity(shirtsIntent);
            }
        });

        cvCategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shirtsIntent = new Intent(MainActivity.this, ListActivity.class);
                shirtsIntent.putExtra(ITEM_DETAIL_KEY, ApparelProvider.getChinoItems());
                startActivity(shirtsIntent);
            }
        });

        cvCategory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shirtsIntent = new Intent(MainActivity.this, ListActivity.class);
                shirtsIntent.putExtra(ITEM_DETAIL_KEY, ApparelProvider.getShoeItems());
                startActivity(shirtsIntent);
            }
        });
    }
}
