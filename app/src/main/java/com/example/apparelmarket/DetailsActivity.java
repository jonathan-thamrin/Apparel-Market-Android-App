package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvItemName;
    private TextView tvItemPrice;
    private TextView tvItemDetail;
    private CarouselView carouselView;
    private int[] resIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvItemName = (TextView) findViewById(R.id.tvItemName);
        tvItemPrice = (TextView) findViewById(R.id.tvItemPrice);
        tvItemDetail = (TextView) findViewById(R.id.tvItemDetail);

        Intent incomingItem = getIntent();
        // Populates data into view. Retrieves from the intent.
        ApparelItem item = (ApparelItem) incomingItem.getSerializableExtra(MainActivity.ITEM_DETAIL_KEY);

        tvItemName.setText(item.getName());
        tvItemPrice.setText(item.getPrice());
        tvItemDetail.setText(item.getDetail());
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
