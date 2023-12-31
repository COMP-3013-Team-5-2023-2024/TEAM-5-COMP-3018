package com.example.periodtracker;


import android.Manifest;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class Today extends AppCompatActivity {

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

    private TextView minPrediction;
    private TextView maxPrediction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        minPrediction = findViewById(R.id.minPredictionText);
        maxPrediction = findViewById(R.id.maxPredictionText);

        buttonClickAnimation = new AlphaAnimation(1,0);
        buttonClickAnimation.setDuration(300);
        currentDate = Calendar.getInstance();
        locale = Locale.getDefault();
        displayDay = findViewById(R.id.day);
        displayMonth = findViewById(R.id.month);
        displayDay.setText(String.valueOf(currentDate.get(Calendar.DAY_OF_MONTH)));
        displayMonth.setText(currentDate.getDisplayName(Calendar.MONTH, Calendar.SHORT, locale));


        // add this to the bottom of pages for navigation
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set to highlight current page, edit item id according to button id
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Perform item selected listener
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.health){
                startActivity(new Intent(getApplicationContext(),Health.class));
                overridePendingTransition(0,0);
                return true;
            }
            else if(item.getItemId() == R.id.home){
                startActivity(new Intent(getApplicationContext(),Home.class));
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

        ActivityResultContracts.RequestMultiplePermissions resultContract = new ActivityResultContracts.RequestMultiplePermissions();
        ActivityResultLauncher<String[]> multiplePermLauncher = registerForActivityResult(resultContract,
                isGranted -> {
                    // Any permission specific code put here:
                });
        multiplePermLauncher.launch(REQUIRED_PERMISSIONS);

    }

    public void onSelectDateClick(View view) {
        MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText(getString(R.string.select_date))
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(selection), ZoneId.systemDefault());
                LocalDate selectedDate = dateTime.toLocalDate();
                MenstrualCycleTracker.PeriodPrediction prediction = MenstrualCycleTracker.trackMenstrualCycle(selectedDate);
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                minPrediction.setText(prediction.minEndDate.format(format));
                maxPrediction.setText(prediction.maxEndDate.format(format));
            }
        });

        materialDatePicker.show(getSupportFragmentManager(), "tag");
    }

}