package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvItemName;
    private TextView tvItemPrice;
    private TextView tvItemDetail;
    private ImageView ivItemImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvItemName = (TextView) findViewById(R.id.tvItemName);
        tvItemPrice = (TextView) findViewById(R.id.tvItemPrice);
        tvItemDetail = (TextView) findViewById(R.id.tvItemDetail);
        ivItemImg = (ImageView) findViewById(R.id.ivItemImg);

        Intent incomingItem = getIntent();
        // Populates data into view. Retrieves from the intent.
        ApparelItem item = (ApparelItem) incomingItem.getSerializableExtra(MainActivity.ITEM_DETAIL_KEY);

        tvItemName.setText(item.getName());
        tvItemPrice.setText(item.getPrice());
        tvItemDetail.setText(item.getDetail());
        int resID = item.getItemImage();
        ivItemImg.setImageResource(resID);
    }
}
