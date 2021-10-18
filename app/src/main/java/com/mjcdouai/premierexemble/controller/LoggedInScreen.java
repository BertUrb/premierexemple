package com.mjcdouai.premierexemble.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mjcdouai.premierexemble.R;
import com.mjcdouai.premierexemble.model.CustomAdapter;
import com.mjcdouai.premierexemble.model.FootballPlayer;

import java.net.URL;
import java.util.ArrayList;

public class LoggedInScreen extends AppCompatActivity {

    private TextView mWelcomeText;
    private RecyclerView mPlayerListRecyclerView;
    private ArrayList<FootballPlayer> mFootballPlayerArrayList = new ArrayList<>();
    private CustomAdapter CustomAd;
    private LinearLayoutManager mRecentLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_screen);

        Intent intent = getIntent();


        mWelcomeText = findViewById(R.id.textView2);
        mPlayerListRecyclerView = findViewById(R.id.player_list);

        String text = getString(R.string.welcome_messages, intent.getStringExtra(MainActivity.sMESSAGE));

        mWelcomeText.setText(text  );
        try {
            FootballPlayer fp1 = new FootballPlayer("Keylor Navas", new URL("https://assets-fr.imgfoot.com/keylor-navas-psg-2021-604e75d5796aa.jpg"));
            mFootballPlayerArrayList.add(fp1);
            FootballPlayer fp2 = new FootballPlayer("Achraf Hakimi", new URL("https://images.psg.media/media/207372/17.jpg?"));
            mFootballPlayerArrayList.add(fp2);
            FootballPlayer fp3 = new FootballPlayer("Presnel Kimpembe", new URL("https://www.sofoot.com/IMG/joueurs/presnel-kimpembe-218649.jpg"));
            mFootballPlayerArrayList.add(fp3);
            FootballPlayer fp4 = new FootballPlayer("Sergio Ramos", new URL("https://images.psg.media/media/207467/19.jpg"));
            mFootballPlayerArrayList.add(fp4);
        }
        catch (Exception e)
        {

        }
        CustomAd = new CustomAdapter(mFootballPlayerArrayList);
        mPlayerListRecyclerView.setAdapter(CustomAd);
        mRecentLayoutManager = new LinearLayoutManager(this);
        mPlayerListRecyclerView.setLayoutManager(mRecentLayoutManager);
        CustomAd.notifyDataSetChanged();












    }
}