package com.example.periodtracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

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
        switch(month){
            case(1):{monthView.setText("Jan");}
            case(2):{monthView.setText("Feb");}
            case(3):{monthView.setText("Mar");}
            case(4):{monthView.setText("Apr");}
            case(5):{monthView.setText("May");}
            case(6):{monthView.setText("Jun");}
            case(7):{monthView.setText("Jul");}
            case(8):{monthView.setText("Aug");}
            case(9):{monthView.setText("Sep");}
            case(10):{monthView.setText("Oct");}
            case(11):{monthView.setText("Nov");}
            case(12):{monthView.setText("Dec");}
            break;
        }
    }
}