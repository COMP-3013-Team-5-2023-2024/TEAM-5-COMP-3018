package com.example.periodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;
import com.example.periodtracker.databinding.ActivitySymptomsInputBinding;
import java.time.LocalDate;

/**
 * SymptomsInputActivity is the class that allows the user to input and store their symptomsRecord.
 */
public class SymptomsInputActivity extends AppCompatActivity {

    private SymptomsRecord symptomsRecord = new SymptomsRecord();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySymptomsInputBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_symptoms_input);
        binding.setSymptom(symptomsRecord);
    }

    /**
     * OnClick handler for save button.
     *
     * @param view  Current view
     */
    public void onSaveClick(View view) {
        // Android room access has to be in background thread.
        new Thread(() -> {
            symptomsRecord.date = LocalDate.now();

            AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, getString(R.string.database_name)).build();
            SymptomsDao symptomsDao = database.symptomsDAO();
            if (symptomsDao != null) {
                symptomsDao.insertAll(symptomsRecord);
            }
            database.close();
        }).start();

        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}