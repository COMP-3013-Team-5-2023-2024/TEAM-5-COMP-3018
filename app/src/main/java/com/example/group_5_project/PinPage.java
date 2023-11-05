package com.example.group_5_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class PinPage extends AppCompatActivity implements View.OnClickListener {
    public static final int PIN_LENGTH = 4;
    View[] dots = new View[4];
    private String PinToTest = "";

    // could add fail limit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_page);

        // maybe rename this to make it more readable
        dots[0] = findViewById(R.id.digit_display_01);
        dots[1] = findViewById(R.id.digit_display_02);
        dots[2] = findViewById(R.id.digit_display_03);
        dots[3] = findViewById(R.id.digit_display_04);

    }

    @Override
    public void onClick(View view) {
        int viewID = view.getId();

        // would use case statement instead but gives error

        if (R.id.pin_pad_01 == viewID) {
            addToPin('1');
            updateDisplay();
        } else if (R.id.pin_pad_02 == viewID) {
            addToPin('2');
            updateDisplay();
        } else if (R.id.pin_pad_03 == viewID) {
            addToPin('3');
            updateDisplay();
        } else if (R.id.pin_pad_04 == viewID) {
            addToPin('4');
            updateDisplay();
        } else if (R.id.pin_pad_05 == viewID) {
            addToPin('5');
            updateDisplay();
        } else if (R.id.pin_pad_06 == viewID) {
            addToPin('6');
            updateDisplay();
        } else if (R.id.pin_pad_07 == viewID) {
            addToPin('7');
            updateDisplay();
        } else if (R.id.pin_pad_08 == viewID) {
            addToPin('8');
            updateDisplay();
        } else if (R.id.pin_pad_09 == viewID) {
            addToPin('9');
            updateDisplay();
        } else if (R.id.pin_pad_00 == viewID) {
            addToPin('0');
            updateDisplay();
        } else if (R.id.pin_pad_back_space == viewID) {
            removeFromPin();
            updateDisplay();
        } else if (R.id.pin_pad_OK == viewID) {
            end();
        }

    }

    public void updateDisplay() {
        for (int i = 0; i < PIN_LENGTH; i++) {
            if (PinToTest.length() <= i) {
                dots[i].setBackgroundResource(R.drawable.pin_page_no_digit);
            } else {
                dots[i].setBackgroundResource(R.drawable.pin_page_digit);
            }
        }
    }

    private void addToPin(char num) {
        if (PinToTest.length() < PIN_LENGTH) {
            PinToTest += num;
        }
    }

    private String getStoredPin() {
        // need to actually implement this thing
        String pin = "2345";
        if (pin.length() > PIN_LENGTH) {
            throw new RuntimeException("pin bad");
        }
        return pin;
    }

    private void removeFromPin() {
        if (PinToTest.length() >= 1) {
            PinToTest = PinToTest.substring(0, PinToTest.length() - 1);
        }
    }

    private void end() {

        // could make an animation play on failure
        if (PinToTest.equals(getStoredPin())) {
            Intent intent = new Intent();
            setResult(Activity.RESULT_OK, intent);
            finish();
        } else {
            PinToTest = "";
            updateDisplay();
        }
    }
}