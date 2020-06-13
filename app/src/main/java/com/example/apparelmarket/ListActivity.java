package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.apparelmarket.models.ApparelItem;
import com.example.apparelmarket.models.ApparelProvider;
import com.example.apparelmarket.models.ItemAdapter;
import com.example.apparelmarket.models.SearchClass;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    // Pulling together ItemAdapter and initialising the custom Layout XML with all the books.
    public static final String ITEM_DETAIL_KEY = "item";
    // From activity_list.xml
    RecyclerView lvItems;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        GridLayoutManager gm = new GridLayoutManager(this,2);
        lvItems = (RecyclerView) findViewById(R.id.lvItems);
        Intent thisIntent = getIntent();
        // Intent passes a query
        String query =  thisIntent.getStringExtra(MainActivity.ITEM_DETAIL_KEY);
        //Query is used to generate the array
        final ArrayList<ApparelItem> categoryItems = SearchClass.searchFunction(query, ApparelProvider.dataArray);
        // Sets the adapter for the ListView for items in specified category.
        itemAdapter = new ItemAdapter(categoryItems);
        lvItems.setLayoutManager(gm);
        lvItems.setAdapter(itemAdapter);

        if (!(categoryItems.get(0).getId() == "null")) {
            itemAdapter.setOnItemClickListner(new ItemAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                    intent.putExtra(ITEM_DETAIL_KEY, categoryItems.get(position).getId());
                    startActivity(intent);
                }
            });
        }
    }
}