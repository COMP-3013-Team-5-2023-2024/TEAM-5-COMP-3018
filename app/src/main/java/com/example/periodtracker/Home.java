package com.example.periodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        LocalDate today = LocalDate.now();
        LocalDate yest = today.minusDays(1);
        LocalDate tomo = today.plusDays(1);
        int month = today.getMonthValue();
        final Button todayButton = findViewById(R.id.button);
        final Button yestButton = findViewById(R.id.button2);
        final Button tomoButton = findViewById(R.id.button3);
        todayButton.setText(String.format(Integer.toString(today.getDayOfMonth())));
        yestButton.setText(String.format(Integer.toString(yest.getDayOfMonth())));
        tomoButton.setText(String.format(Integer.toString(tomo.getDayOfMonth())));
        final TextView monthView = findViewById(R.id.textView);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
        monthView.setText(today.format(formatter));
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set to highlight current page
        bottomNavigationView.setSelectedItemId(R.id.home);
        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home){
                startActivity(new Intent(getApplicationContext(), Home.class));
                overridePendingTransition(0,0);
                return true;
            }
            else if(item.getItemId() == R.id.health){
                startActivity(new Intent(getApplicationContext(), Health.class));
                overridePendingTransition(0,0);
                return true;
            }
            else if(item.getItemId() == R.id.symptoms){
                startActivity(new Intent(getApplicationContext(), SymptomsActivity.class));
                overridePendingTransition(0,0);
                return true;
            }
            else{
                return false;
            }
        });
    }

    public void onYestPressed(View v){}

    public void onTodayPressed(View v){}

    public void onTomoPressed(View v){}

    public void onEditPressed(View v){
        startActivity(new Intent(this, Today.class));
    }

}