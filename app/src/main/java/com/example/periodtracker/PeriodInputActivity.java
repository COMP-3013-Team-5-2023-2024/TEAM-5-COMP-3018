package com.example.periodtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import org.w3c.dom.Text;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Class that represents the period input activity
 */
public class PeriodInputActivity extends AppCompatActivity {

    private PeriodRecord periodRecord = new PeriodRecord();

    private TextView startDateText;
    private TextView endDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period_input);

        startDateText = findViewById(R.id.startTextDate);
        endDateText = findViewById(R.id.endTextDate);

        startDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectStartDateClick(v);
            }
        });

        endDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectDateEndClick(v);
            }
        });
    }

    /**
     * Method for when user is selecting a period start date.
     * @param view Current View
     */
    public void onSelectStartDateClick(View view) {
        MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText(getString(R.string.select_date))
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(selection), ZoneId.systemDefault());
                LocalDate selectedDate = dateTime.toLocalDate();
                periodRecord.startDate = selectedDate;
                startDateText.setText(selectedDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            }
        });

        materialDatePicker.show(getSupportFragmentManager(), "tag");
    }

    /**
     * Method for when user is selecting a period end date.
     * @param view Current View
     */
    public void onSelectDateEndClick(View view) {
        MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText(getString(R.string.select_date))
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) {
                LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(selection), ZoneId.systemDefault());
                LocalDate selectedDate = dateTime.toLocalDate();
                periodRecord.endDate = selectedDate;
                endDateText.setText(selectedDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            }
        });

        materialDatePicker.show(getSupportFragmentManager(), "tag");
    }

    /**
     * OnClick handler for save button.
     *
     * @param view  Current view
     */
    public void onSaveClick(View view) {
        // Android room access has to be in background thread.
        new Thread(() -> {
            AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, getString(R.string.database_name)).build();
            PeriodDao periodDao = database.periodDao();
            if (periodDao != null) {
                periodDao.insertAll(periodRecord);
            }
            database.close();
        }).start();

        Intent mainIntent = new Intent(this, Home.class);
        startActivity(mainIntent);
    }
}