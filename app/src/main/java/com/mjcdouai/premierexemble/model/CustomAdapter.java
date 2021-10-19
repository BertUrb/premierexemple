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

    public static final String MESSAGE_URL = "com.mjcdouai.premierexemble.controller.url";
    public static final String MESSAGE_NAME = "com.mjcdouai.premierexemble.controller.name";
    public static final String MESSAGE_DESC = "com.mjcdouai.premierexemble.controller.desc";

    private ArrayList<FootballPlayer> mFootballPlayerArrayList = new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView mImageView;
        private final ImageButton mDeleteButton;




        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.player_text);
            mImageView = view.findViewById(R.id.player_image);
            mDeleteButton = view.findViewById(R.id.item_list_player_delete_button);

        }

        public TextView getTextView() {
            return textView;
        }
        public ImageView getImageView() {
            return mImageView;
        }
        public ImageButton getDeleteButton() { return mDeleteButton;  }

    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(ArrayList<FootballPlayer> dataSet) {
        mFootballPlayerArrayList = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_player, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(mFootballPlayerArrayList.get(position).getName());
        Glide.with(viewHolder.itemView)
                .asDrawable()
                .load(mFootballPlayerArrayList.get(position).getPhotoUrl())

                .override(200, 200) // resizing
                .centerCrop()
                .into(viewHolder.getImageView());
        viewHolder.getImageView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent PlayerDetailsIntent = new Intent(v.getContext(),Player_details.class);
                PlayerDetailsIntent.putExtra(MESSAGE_NAME,mFootballPlayerArrayList.get( viewHolder.getAdapterPosition()).getName());
                PlayerDetailsIntent.putExtra(MESSAGE_URL,mFootballPlayerArrayList.get( viewHolder.getAdapterPosition()).getPhotoUrl().toString());

                PlayerDetailsIntent.putExtra(MESSAGE_DESC,mFootballPlayerArrayList.get( viewHolder.getAdapterPosition()).getDesc());

                v.getContext().startActivity(PlayerDetailsIntent);
            }
        });

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
