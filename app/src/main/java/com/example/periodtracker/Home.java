package com.example.periodtracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
    }
}