package com.example.periodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    public void onYestPressed(View v){}

    public void onTodayPressed(View v){}

    public void onTomoPressed(View v){}

    public void onEditPressed(View v){
        startActivity(new Intent(this, Today.class));
    }

    public void onHealthPressed(View v){
        startActivity(new Intent(this, Health.class));
    }

    public void onSymptomsPressed(View v){
        startActivity(new Intent(this, SymptomsActivity.class));
    }
}