package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apparelmarket.models.ApparelItem;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvItemName;
    private TextView tvItemPrice;
    private TextView tvItemDetail;
    private TextView tvItemViews;
    private CarouselView carouselView;
    private int[] resIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvItemName = (TextView) findViewById(R.id.tvItemName);
        tvItemPrice = (TextView) findViewById(R.id.tvItemPrice);
        tvItemDetail = (TextView) findViewById(R.id.tvItemDetail);
        tvItemViews = (TextView) findViewById(R.id.tvItemViews);

        // Retrieves data from the intent sent from ListActivity.
        Intent incomingItem = getIntent();
        ApparelItem item =  (ApparelItem) incomingItem.getSerializableExtra(MainActivity.ITEM_DETAIL_KEY);

        // Appropriate Views are updated accordingly.
        tvItemName.setText(item.getName());
        tvItemPrice.setText(item.getPrice());
        tvItemDetail.setText(item.getDetail());
        tvItemViews.setText(String.valueOf(item.getItemView()));
        resIDs = item.getItemImage();

        // CarouselView - Credits to Sayyam - https://github.com/sayyam/carouselview
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(resIDs.length);
        carouselView.setImageListener(imageListener);
    }

    // CarouselView - Credits to Sayyam - https://github.com/sayyam/carouselview
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(resIDs[position]);
        }
    };
}
