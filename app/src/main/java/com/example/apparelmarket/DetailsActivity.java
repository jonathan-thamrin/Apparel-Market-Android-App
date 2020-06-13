package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apparelmarket.models.ApparelItem;
import com.example.apparelmarket.models.ApparelProvider;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.w3c.dom.Text;

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

        Intent incomingItem = getIntent();
        // Populates data into view. Retrieves from the intent.
        String incomingitemString =  incomingItem.getStringExtra(MainActivity.ITEM_DETAIL_KEY);
        ApparelItem item = ApparelProvider.dataArray.get((Integer.parseInt(incomingitemString)) - 1);

        tvItemName.setText(item.getName());
        tvItemPrice.setText(item.getPrice());
        tvItemDetail.setText(item.getDetail());
        tvItemViews.setText(String.valueOf(item.getItemView()));
        resIDs = item.getItemImage();
        item.incrementViews();

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
