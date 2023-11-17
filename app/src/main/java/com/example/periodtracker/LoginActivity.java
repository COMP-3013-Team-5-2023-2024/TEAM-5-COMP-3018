package com.example.periodtracker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences userData;
    private TextView welcomeBack;
    private String userName;

    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHandler = new DBHandler(LoginActivity.this);
        userData = getSharedPreferences("userData", Context.MODE_PRIVATE);
        welcomeBack = findViewById(R.id.welcomeBack);
        userName = userData.getString("userName", "DEFAULT");
        welcomeBack.setText("Welcome Back, " + userName);

    }



}