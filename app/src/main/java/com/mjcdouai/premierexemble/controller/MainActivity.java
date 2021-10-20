package com.mjcdouai.premierexemble.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.mjcdouai.premierexemble.R;
import com.mjcdouai.premierexemble.model.User;

public class MainActivity extends AppCompatActivity {

    public static final String sMESSAGE = "com.mjcdouai.premierexemble.controller.message";
    private static final String SHARED_PREF_USER_INFO = "SHARED_PREF_USER_INFO";
    private static final String SHARED_PREF_USER_INFO_MAIL = "SHARED_PREF_USER_INFO_MAIL";
    private static final String SHARED_PREF_USER_INFO_REMEMBER = "SHARED_PREF_USER_INFO_REMEMBER";

    private EditText mLoginEditText;
    private EditText mPassEditText;
    private Button mLoginButton;
    private TextView mErrorText;
    private CheckBox mCheckBox;


    private final User mUser=new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginEditText = findViewById(R.id.editTextTextEmailAddress);
        mPassEditText = findViewById(R.id.editTextTextPassword);
        mLoginButton = findViewById(R.id.buttonLogin);
        mErrorText = findViewById(R.id.textViewLoginError);
        mCheckBox = findViewById(R.id.checkBoxRememberMe);

        mLoginButton.setEnabled(false);
        String mail = getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE).getString(SHARED_PREF_USER_INFO_MAIL, "");
        if(!mail.isEmpty()) {
            mUser.setMail(mail);
            mLoginEditText.setText(mail);
        }

        mCheckBox.setChecked(getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE).getBoolean(SHARED_PREF_USER_INFO_REMEMBER,false));

        mPassEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mLoginButton.setEnabled(!s.toString().isEmpty());
            }
        });

        mLoginButton.setOnClickListener(v -> {
            // enregistrement préférences utilisateur
            SharedPreferences preferences = getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            if(mCheckBox.isChecked()) {
                editor.putString(SHARED_PREF_USER_INFO_MAIL, mLoginEditText.getText().toString());
                editor.putBoolean(SHARED_PREF_USER_INFO_REMEMBER, mCheckBox.isChecked());

            }
            else {
                editor.remove(SHARED_PREF_USER_INFO_MAIL);
                editor.remove(SHARED_PREF_USER_INFO_REMEMBER);
            }

            editor.apply();

            // <== Fin enregistrement
            if (mLoginEditText.getText().toString().equals("admin@admin.com") && mPassEditText.getText().toString().equals("admin"))
            {

                mUser.setMail(mLoginEditText.getText().toString());

                Intent LoggedInScreenIntent = new Intent(MainActivity.this, LoggedInScreen.class);
                LoggedInScreenIntent.putExtra(sMESSAGE, getUserMail());



                startActivity(LoggedInScreenIntent);

            }
            else {
                mErrorText.setVisibility(View.VISIBLE);
            }


        });



    }
    public String getUserMail()
    {
        return mUser.getMail();
    }
}