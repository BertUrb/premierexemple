package com.mjcdouai.premierexemble.controller;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.mjcdouai.premierexemble.R;
import com.mjcdouai.premierexemble.model.CustomAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;

public class Player_details extends AppCompatActivity {

private TextView mPlayerNameTextView;
private TextView mPlayerDescTextView;
private ImageView mPlayerPhotoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);

        mPlayerDescTextView = findViewById(R.id.player_desc);
        mPlayerNameTextView = findViewById(R.id.player_name);
        mPlayerPhotoImageView = findViewById(R.id.player_full_image);

        Intent intent = getIntent();
        String str = intent.getStringExtra(CustomAdapter.MESSAGE_URL);
        mPlayerNameTextView.setText(intent.getStringExtra(CustomAdapter.MESSAGE_NAME));
        mPlayerDescTextView.setText(intent.getStringExtra(CustomAdapter.MESSAGE_DESC ));


        URL url = null;
        try {
            URI uri = new URI(str);
            url = uri.toURL();
        }
        catch (Exception e){ }
        Glide.with(this)
                .asDrawable()
                .load(url)
                .into(mPlayerPhotoImageView);
    }
}