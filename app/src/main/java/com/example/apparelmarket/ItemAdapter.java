package com.example.apparelmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<ApparelItem> {

    private static class ViewHolder {
        // Variables for views created previously in the new book row layout.
        public ImageView ivItemImage;
        public TextView tvItemName;
        public TextView tvItemPrice;
    }

    public ItemAdapter(Context context, ArrayList<ApparelItem> apparelItems) {
        super(context, 0, apparelItems);
    }

    @Override
    // Prepares the view for the Apparel Items. Position in the ApparelItems list is given and
    // displayed as a CardView within an AdapterView.
    public View getView(int position, View convertView, ViewGroup parent) {

        // Gets an Apparel Item from a position (function from ArrayAdapter).
        final ApparelItem item = getItem(position);
        ViewHolder viewHolder;

        // Inflating the view (taking appropriate layout XML and parsing it to display the items accordingly).
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Assigns convertView input with new inflater (list_item XML).
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            // Assigns Views present in list_item XML.
            viewHolder.ivItemImage = (ImageView) convertView.findViewById(R.id.ivItemImg);
            viewHolder.tvItemName = (TextView) convertView.findViewById(R.id.tvItemName);
            viewHolder.tvItemPrice = (TextView) convertView.findViewById(R.id.tvItemPrice);
            // Sets tag associated with convertView (Layout XML).
            convertView.setTag(viewHolder);
        } else {
            // If an existing view exists, inflate that view instead.
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Adds the data into the template view (activity_list).
        viewHolder.ivItemImage.setImageResource(item.getItemImage()[0]);
        viewHolder.tvItemName.setText(item.getName());
        viewHolder.tvItemPrice.setText(item.getPrice());

        return convertView;
    }
}
