package com.example.periodtracker;


import android.Manifest;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView displayDay;
    private TextView displayMonth;
    private Calendar currentDate;
    private Locale locale;
    private AlphaAnimation buttonClickAnimation;

    /**
     * Required permissions for the app to work.
     */
    static final String[] REQUIRED_PERMISSIONS = {
            Manifest.permission.POST_NOTIFICATIONS,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClickAnimation = new AlphaAnimation(1,0);
        buttonClickAnimation.setDuration(300);
        currentDate = Calendar.getInstance();
        locale = Locale.getDefault();
        displayDay = findViewById(R.id.day);
        displayMonth = findViewById(R.id.month);
        displayDay.setText(String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH)));
        displayMonth.setText(currentDate.getDisplayName(Calendar.MONTH, Calendar.SHORT, locale));

        Button btn_tick = findViewById(R.id.btn_tick);
        btn_tick.setOnClickListener(v -> {
            ImageView periodBtnTick = findViewById(R.id.periodBtnTick);
            v.startAnimation(buttonClickAnimation);
            int visibility = periodBtnTick.getVisibility();
            if(visibility == View.VISIBLE)
            {
                periodBtnTick.startAnimation(buttonClickAnimation);
                periodBtnTick.setVisibility(View.GONE);
            }
            else
            {
                periodBtnTick.setVisibility(View.VISIBLE);
            }
        });


        // add this to the bottom of pages for navigation
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set to highlight current page, edit item id according to button id
        bottomNavigationView.setSelectedItemId(R.id.today);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.health){
                    startActivity(new Intent(getApplicationContext(),Health.class));
                    overridePendingTransition(0,0);
                return true;
            }
            else if(item.getItemId() == R.id.today){
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

        ActivityResultContracts.RequestMultiplePermissions resultContract = new ActivityResultContracts.RequestMultiplePermissions();
        ActivityResultLauncher<String[]> multiplePermLauncher = registerForActivityResult(resultContract,
                isGranted -> {
                    // Any permission specific code put here:
                });
        multiplePermLauncher.launch(REQUIRED_PERMISSIONS);

    }

}
