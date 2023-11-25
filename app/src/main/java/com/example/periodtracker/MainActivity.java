package com.example.periodtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.group_5_project.R;

public class MainActivity extends AppCompatActivity {
    // TODO (matthew fletcher) this activity can be changed at the moment this is just here so that you can access the pin page
    public static final int MY_REQUEST_CODE = 1;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Log.d("PageCreation", "received result");
                    }
                }
        );
        Intent intent = new Intent(MainActivity.this, PinPage.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                // do the rest of stuff
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // error / failure
            }
        }
    }
}