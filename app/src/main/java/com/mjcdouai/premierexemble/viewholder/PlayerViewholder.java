package com.mjcdouai.premierexemble.viewholder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mjcdouai.premierexemble.R;
import com.mjcdouai.premierexemble.callback.OnClickPlayerListener;

public class PlayerViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    private final TextView textView;
    private final ImageView mImageView;
    private final ImageButton mDeleteButton;
    private final OnClickPlayerListener onClickPlayerListener;

    public PlayerViewholder(View view, OnClickPlayerListener onClickPlayerListener) {
        super(view);
        // Define click listener for the ViewHolder's View

        textView = (TextView) view.findViewById(R.id.player_text);
        mImageView = view.findViewById(R.id.player_image);
        mDeleteButton = view.findViewById(R.id.item_list_player_delete_button);
        view.setOnClickListener(this);
        this.onClickPlayerListener = onClickPlayerListener;

    }

    @Override
    public void onClick(View view) {
        onClickPlayerListener.onPlayerClick(getAdapterPosition());
    }

    public TextView getTextView() {
        return textView;
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public ImageButton getDeleteButton() {
        return mDeleteButton;
    }


}

