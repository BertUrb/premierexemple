package com.mjcdouai.premierexemble.model;

import com.bumptech.glide.Glide;
import com.mjcdouai.premierexemble.R;
import com.mjcdouai.premierexemble.callback.OnClickPlayerListener;
import com.mjcdouai.premierexemble.viewholder.PlayerViewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<PlayerViewholder> {

    private final ArrayList<FootballPlayer> mFootballPlayerArrayList;
    private final OnClickPlayerListener mOnClickPlayerListener;



    /**
     * Initialize the dataset of the Adapter
     */
    public CustomAdapter(ArrayList<FootballPlayer> dataSet, OnClickPlayerListener onClickPlayerListener) {
        mFootballPlayerArrayList = dataSet;
        mOnClickPlayerListener = onClickPlayerListener;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public PlayerViewholder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_player, viewGroup, false);

        return new PlayerViewholder(view, mOnClickPlayerListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(PlayerViewholder viewHolder, final int position)  {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(mFootballPlayerArrayList.get(position).getName());
        Glide.with(viewHolder.itemView)
                .load(mFootballPlayerArrayList.get(position).getPhotoUrl())
                .override(200, 200) // resizing
                .centerCrop()
                .into(viewHolder.getImageView());

        viewHolder.getDeleteButton().setOnClickListener(v -> {
                         // remove your item from data base
            mFootballPlayerArrayList.remove(viewHolder.getAdapterPosition());  // remove the item from list
            notifyItemRemoved(viewHolder.getAdapterPosition()); // notify the adapter about the removed item
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mFootballPlayerArrayList.size();
    }


}
