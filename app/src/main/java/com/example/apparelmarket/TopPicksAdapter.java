package com.example.apparelmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.apparelmarket.models.ApparelItem;

import java.util.ArrayList;

public class TopPicksAdapter extends RecyclerView.Adapter<TopPicksAdapter.TopPickitemViewHolder> {

    private ArrayList<ApparelItem> listofitems = new ArrayList<ApparelItem>();
    private TopPicksAdapter.OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListner(TopPicksAdapter.OnItemClickListener listener) {
        clickListener = listener;
    }

    public static class TopPickitemViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivImage;
        public TextView  tvName;

        public TopPickitemViewHolder(@NonNull View itemView, final OnItemClickListener passed) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.TopPicksImage);
            tvName = itemView.findViewById(R.id.TopPicksText);

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
    public TopPickitemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_toppicks, parent, false);
        TopPicksAdapter.TopPickitemViewHolder itemviews = new TopPicksAdapter.TopPickitemViewHolder(v, clickListener);
        return itemviews;
    }

    public TopPicksAdapter() {

    }

    @Override
    public void onBindViewHolder(@NonNull TopPicksAdapter.TopPickitemViewHolder holder, int position) {
        int resID =  SessionClass.toppickarray.get(position).getItemImage()[0];

        holder.tvName.setText(SessionClass.toppickarray.get(position).getName());
        holder.ivImage.setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return SessionClass.toppickarray.size();
    }


}