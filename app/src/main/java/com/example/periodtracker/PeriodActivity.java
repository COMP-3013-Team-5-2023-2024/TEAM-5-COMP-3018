package com.example.periodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * This class represents the period activity that the user can access.
 */
public class PeriodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periods);
        RecyclerView recyclerView = findViewById(R.id.periodRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PeriodRecyclerViewAdapter adapter = new PeriodRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);

        // add this to the bottom of pages for navigation
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set to highlight current page
        bottomNavigationView.setSelectedItemId(R.id.period);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                startActivity(new Intent(this, Home.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.symptoms) {
                return true;
            } else if (item.getItemId() == R.id.health) {
                startActivity(new Intent(this, Health.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.period) {
                startActivity(new Intent(this, PeriodActivity.class));
                overridePendingTransition(0,0);
                return true;
            } else {
                return false;
            }
        });
    }

    /**
     * Click handler for the period input button.
     *
     * @param view The current view.
     */
    public void onPeriodInputClick(View view) {
        Intent inputIntent = new Intent(this, PeriodInputActivity.class);
        startActivity(inputIntent);
    }

}
