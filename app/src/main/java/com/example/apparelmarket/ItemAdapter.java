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
        public TextView tvItemDetail;
    }

    // Need to google what this does.
    public ItemAdapter(Context context, ArrayList<ApparelItem> apparelItems) {
        super(context, 0, apparelItems);
    }

    @Override
    // Prepares the view for our Book. Position in Books list is given and
    // displayed as a row within an AdapterView.
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get book from position (function from ArrayAdapter.
        // Previously, constructor gave List of Books).
        final ApparelItem item = getItem(position);

        ViewHolder viewHolder;

        // Inflating the view (taking layout XML and parsing it to display the book accordingly).
        if(convertView == null) {
            // Creates instance containing appropriate attributes (Book cover, title and author).
            viewHolder = new ViewHolder();
            // Layout XML.
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Assigns convertView input with new inflater (Layout XML).
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            // Assigns those attributes.
            viewHolder.ivItemImage = (ImageView) convertView.findViewById(R.id.ivItemImg);
            viewHolder.tvItemName = (TextView) convertView.findViewById(R.id.tvItemName);
            viewHolder.tvItemPrice = (TextView) convertView.findViewById(R.id.tvItemPrice);
            // Sets tag associated with convertView (Layout XML).
            convertView.setTag(viewHolder);
        } else {
            // If an existing view exists, inflate the view.
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Adds the data into the template view (item_book). Remember attributes are types of Views.
        viewHolder.ivItemImage.setImageResource(item.getItemImage());
        viewHolder.tvItemName.setText(item.getName());
        viewHolder.tvItemPrice.setText(item.getPrice());

        return convertView;
    }
}
