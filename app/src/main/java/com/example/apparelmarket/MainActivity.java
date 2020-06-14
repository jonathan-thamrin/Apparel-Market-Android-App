package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.example.apparelmarket.models.ApparelProvider;
import com.example.apparelmarket.models.SessionClass;
import com.example.apparelmarket.models.TopPicksAdapter;

public class MainActivity extends AppCompatActivity {

    public static final String ITEM_DETAIL_KEY = "item";
    CardView cvCategory1, cvCategory2, cvCategory3;

    RecyclerView toppicksRecycle;
    TopPicksAdapter topadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ApparelProvider.dataArray.isEmpty() || SessionClass.toppickarray.isEmpty()) {
            ApparelProvider.generateData();
            SessionClass.generateData();
        }

        // Initialising ListView from activity_main.xml
        cvCategory1 = (CardView) findViewById(R.id.cvCategory1);
        cvCategory2 = (CardView) findViewById(R.id.cvCategory2);
        cvCategory3 = (CardView) findViewById(R.id.cvCategory3);

        // Sets up a grid-like structure for displaying the Top Pick items.
        GridLayoutManager gm = new GridLayoutManager(this,3);
        SessionClass.largestthree();
        toppicksRecycle = (RecyclerView) findViewById(R.id.TopPicksView);
        topadapter = new TopPicksAdapter(MainActivity.this);

        toppicksRecycle.setLayoutManager(gm);
        toppicksRecycle.setAdapter(topadapter);

        setupCategorySelectedListener();
        setupTopPicksListener();
    }


    // Transitions from MainActivity to DetailsActivity when an item from Top Picks is selected.
    public void setupTopPicksListener() {
        topadapter.setOnItemClickListner(new TopPicksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(ITEM_DETAIL_KEY, SessionClass.toppickarray.get(position).getId());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }

    public void setupCategorySelectedListener() {
        // Sets OnClick Listener for ListView
        // Sends String of query for category, to Display all of a certain category
        cvCategory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shirtsIntent = new Intent(MainActivity.this, ListActivity.class);
                shirtsIntent.putExtra(ITEM_DETAIL_KEY, "Shirt");
                startActivity(shirtsIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        cvCategory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chinosIntent = new Intent(MainActivity.this, ListActivity.class);
                chinosIntent.putExtra(ITEM_DETAIL_KEY, "Chinos");
                startActivity(chinosIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        cvCategory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shoesIntent = new Intent(MainActivity.this, ListActivity.class);
                shoesIntent.putExtra(ITEM_DETAIL_KEY, "Shoes");
                startActivity(shoesIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        //Intent to search
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();

                // Sends an intent with information from MainActivity to ListActivity, to display appropriate
                // item results based on a search.
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
