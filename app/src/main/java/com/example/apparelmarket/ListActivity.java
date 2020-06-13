package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    // Pulling together ItemAdapter and initialising the custom Layout XML with all the books.
    public static final String ITEM_DETAIL_KEY = "item";
    // From activity_list.xml
    ListView lvItems;
    // From Adapter extending ArrayAdapter
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // ListView from activity_list.xml
        lvItems = (ListView) findViewById(R.id.lvItems);

        Intent thisIntent = getIntent();


        // Intent passes a query
        String query =  thisIntent.getStringExtra(MainActivity.ITEM_DETAIL_KEY);
        //Query is used to generate the array
        ArrayList<ApparelItem> categoryItems = SearchClass.searchFunction(query, ApparelProvider.generateData());
        // Sets the adapter for the ListView for items in specified category.
        itemAdapter = new ItemAdapter(this, categoryItems);
        lvItems.setAdapter(itemAdapter);

        if (!(categoryItems.get(0).getId() == "null")) {
            setupItemSelectedListener();
        }
    }

    public void setupItemSelectedListener() {
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                // Sending Data
                intent.putExtra(ITEM_DETAIL_KEY, itemAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }
}