package com.example.apparelmarket.models;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.apparelmarket.ListActivity;
import com.example.apparelmarket.R;

import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemViewHolder> {
    private ArrayList<ApparelItem> listofitems;
    private OnItemClickListener clickListener;
    private int lastPosition = -1;
    Context context;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListner(OnItemClickListener listener) {
        clickListener = listener;
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivImage;
        public TextView  tvName;
        public TextView tvPrice;
        public LinearLayout parent;

        public itemViewHolder(@NonNull View itemView, final OnItemClickListener passed) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivItemImg);
            tvName = itemView.findViewById(R.id.tvItemName);
            tvPrice = itemView.findViewById(R.id.tvItemPrice);
            parent = itemView.findViewById(R.id.parent);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (passed != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            passed.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        itemViewHolder itemviews = new itemViewHolder(v, clickListener);
        return itemviews;


    }

    public ItemAdapter(ArrayList<ApparelItem> list, Context context) {
        listofitems = list;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {
        ApparelItem currentItem = listofitems.get(position);

        int resID = currentItem.getItemImage()[0];
        holder.ivImage.setImageResource(resID);
        holder.tvName.setText(currentItem.getName());
        holder.tvPrice.setText(currentItem.getPrice());
        setAnimation(holder.parent, position);

    }
    private void setAnimation(View viewToAnimate, int position) {
        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_bottom);
        viewToAnimate.startAnimation(animation);
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return listofitems.size();
    }
}

