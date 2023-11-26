package com.example.periodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * The SymptomsActivity displays user input symptoms back to the user.
 */
public class SymptomsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        RecyclerView recyclerView = findViewById(R.id.symptomRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SymptomRecyclerViewAdapter adapter = new SymptomRecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);

        // add this to the bottom of pages for navigation
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set to highlight current page
        bottomNavigationView.setSelectedItemId(R.id.symptoms);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.today) {
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.symptoms) {
                return true;
            } else if (item.getItemId() == R.id.health) {
                startActivity(new Intent(this, Health.class));
                overridePendingTransition(0, 0);
                return true;
            } else {
                return false;
            }
        });
    }

    /**
     * Click handler for the symptom input button.
     *
     * @param view The current view.
     */
    public void onSymptomInputClick(View view) {
        Intent inputIntent = new Intent(this, SymptomsInputActivity.class);
        startActivity(inputIntent);
    }
}