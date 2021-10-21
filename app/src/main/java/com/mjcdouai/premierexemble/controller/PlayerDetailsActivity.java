package com.mjcdouai.premierexemble.controller;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.mjcdouai.premierexemble.R;
import com.mjcdouai.premierexemble.model.CustomAdapter;
import com.mjcdouai.premierexemble.model.FootballPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;

public class PlayerDetailsActivity extends AppCompatActivity {

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
        FootballPlayer player = intent.getParcelableExtra("Joueur");

        mPlayerNameTextView.setText(player.getName());
        mPlayerDescTextView.setText(player.getDesc());




        Glide.with(this)
                .load(player.getPhotoUrl())
                .into(mPlayerPhotoImageView);
    }
}