package com.mjcdouai.premierexemble.model;

import com.bumptech.glide.Glide;
import com.mjcdouai.premierexemble.R;
import com.mjcdouai.premierexemble.controller.LoggedInScreen;
import com.mjcdouai.premierexemble.controller.MainActivity;
import com.mjcdouai.premierexemble.controller.Player_details;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {



    private ArrayList<FootballPlayer> mFootballPlayerArrayList = new ArrayList<>();
    private ViewHolder.onPlayerListener mOnPlayerListener;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView textView;
        private final ImageView mImageView;
        private final ImageButton mDeleteButton;
         onPlayerListener onPlayerListener;



        public ViewHolder(View view,onPlayerListener onPlayerListener) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.player_text);
            mImageView = view.findViewById(R.id.player_image);
            mDeleteButton = view.findViewById(R.id.item_list_player_delete_button);
            view.setOnClickListener(this);
            this.onPlayerListener = onPlayerListener;

        }
        @Override
        public void onClick(View view)
        {
            onPlayerListener.onPlayerClick(getAdapterPosition());
        }

        public TextView getTextView() {
            return textView;
        }
        public ImageView getImageView() {
            return mImageView;
        }
        public ImageButton getDeleteButton() { return mDeleteButton;  }


        public interface onPlayerListener{
            void onPlayerClick(int position);
        }
    }

    /**
     * Initialize the dataset of the Adapter
     */
    public CustomAdapter(ArrayList<FootballPlayer> dataSet, ViewHolder.onPlayerListener pl) {
        mFootballPlayerArrayList = dataSet;
        mOnPlayerListener = pl;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_player, viewGroup, false);

        return new ViewHolder(view,mOnPlayerListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position)  {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(mFootballPlayerArrayList.get(position).getName());
        Glide.with(viewHolder.itemView)
                .asDrawable()
                .load(mFootballPlayerArrayList.get(position).getPhotoUrl())

                .override(200, 200) // resizing
                .centerCrop()
                .into(viewHolder.getImageView());


        viewHolder.getDeleteButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                             // remove your item from data base
                mFootballPlayerArrayList.remove(viewHolder.getAdapterPosition());  // remove the item from list
                notifyItemRemoved(viewHolder.getAdapterPosition()); // notify the adapter about the removed item
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mFootballPlayerArrayList.size();
    }


}
