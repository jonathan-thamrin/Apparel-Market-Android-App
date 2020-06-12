package com.example.apparelmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

//    private ImageView ivItemImg;
//    private TextView tvDescription;
//    private TextView tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

//        ivItemImg = (ImageView) findViewById(R.id.ivItemImg);
//        tvDescription = (TextView) findViewById(R.id.tvDescription);
//        tvCategory = (TextView) findViewById(R.id.tvCategoryName);
//
//        Intent incoming = getIntent();
//        // Populates data into view. Retrieves from the intent.
//        ApparelItem item = (ApparelItem) incoming.getSerializableExtra(MainActivity.ITEM_DETAIL_KEY);
//
//        tvDescription.setText(item.getDetail());
//        tvCategory.setText(item.getCategory());
//        int resID = item.getItemImage();
//        ivItemImg.setImageResource(resID);
    }
}
