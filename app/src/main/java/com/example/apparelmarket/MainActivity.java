package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apparelmarket.models.ApparelProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String ITEM_DETAIL_KEY = "item";
    CardView cvCategory1, cvCategory2, cvCategory3;

    RecyclerView toppicksRecycle;
    TopPicksAdapter topadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApparelProvider.generateData();
        SessionClass.generateData();

        // Initialising ListView from activity_main.xml
        cvCategory1 = (CardView) findViewById(R.id.cvCategory1);
        cvCategory2 = (CardView) findViewById(R.id.cvCategory2);
        cvCategory3 = (CardView) findViewById(R.id.cvCategory3);

        GridLayoutManager gm = new GridLayoutManager(this,3);
        SessionClass.largestthree();
        toppicksRecycle = (RecyclerView) findViewById(R.id.TopPicksView);
        topadapter = new TopPicksAdapter();

        toppicksRecycle.setLayoutManager(gm);
        toppicksRecycle.setAdapter(topadapter);


        setupCategorySelectedListener();
        setupTopPicksListener();
    }

    public void setupTopPicksListener() {
        topadapter.setOnItemClickListner(new TopPicksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(ITEM_DETAIL_KEY, SessionClass.toppickarray.get(position).getId());
                startActivity(intent);
            }
        });

    }

    public void setupCategorySelectedListener() {
        // Sets OnClick Listener for ListView
        // Sends String of query for catagory, to Display all of a certain catagory
        cvCategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shirtsIntent = new Intent(MainActivity.this, ListActivity.class);
                shirtsIntent.putExtra(ITEM_DETAIL_KEY, "Shirt");
                startActivity(shirtsIntent);
            }
        });

        cvCategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shirtsIntent = new Intent(MainActivity.this, ListActivity.class);
                shirtsIntent.putExtra(ITEM_DETAIL_KEY, "Chinos");
                startActivity(shirtsIntent);
            }
        });

        cvCategory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shirtsIntent = new Intent(MainActivity.this, ListActivity.class);
                shirtsIntent.putExtra(ITEM_DETAIL_KEY, "Shoes");
                startActivity(shirtsIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();

       /* SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchActivity.class)));
        searchView.setQueryHint("epic");
        return true;*/

        //Intent to search
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();

                //complete SearchActivity by yourself
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra(ITEM_DETAIL_KEY, query);
                startActivity(intent);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        SessionClass.largestthree();
        topadapter.notifyDataSetChanged();
    }


}
