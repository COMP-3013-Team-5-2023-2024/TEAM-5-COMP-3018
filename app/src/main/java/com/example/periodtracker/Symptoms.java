package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Symptoms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        // add this to the bottom of pages for navigation
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set to highlight current page
        bottomNavigationView.setSelectedItemId(R.id.symptoms);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.today){
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(0,0);
                return true;
            }
            else if(item.getItemId() == R.id.symptoms){
                return true;
            }
            else if(item.getItemId() == R.id.health){
                startActivity(new Intent(getApplicationContext(),Health.class));
                overridePendingTransition(0,0);
                return true;
            }
            else{
                return false;
            }
        });

    }
}