package com.example.periodtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group_5_project.R;

import java.io.Serializable;


public class PinPage extends AppCompatActivity implements View.OnClickListener {

    public static final int PIN_LENGTH = 4;
    private final View[] dots = new View[4];
    private String pinToTest = "";
    private PinPageState saveCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_page);

        // maybe rename this to make it more readable
        dots[0] = findViewById(R.id.digit_display_01);
        dots[1] = findViewById(R.id.digit_display_02);
        dots[2] = findViewById(R.id.digit_display_03);
        dots[3] = findViewById(R.id.digit_display_04);

        // need to check to see what type of application they want

        Serializable check = getIntent().getSerializableExtra("pinPageState");
        if (check != null) {

            saveCheck = (PinPageState) getIntent().getSerializableExtra("pinPageState");
        } else {
            saveCheck = PinPageState.SAVE;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO check to see if this happens when final is called
        if (this.saveCheck == PinPageState.SAVE) {
            setStoredPin("");
        }
    }

    // could add fail limit

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

    private void updateDisplay() {
        for (int i = 0; i < PIN_LENGTH; i++) {
            if (pinToTest.length() <= i) {
                dots[i].setBackgroundResource(R.drawable.pin_page_no_digit);
            } else {
                dots[i].setBackgroundResource(R.drawable.pin_page_digit);
            }
        }
    }

    private void addToPin(char num) {
        if (pinToTest.length() < PIN_LENGTH) {
            pinToTest += num;
        }
    }


    // TODO should be part of another class
    private String getStoredPin() {
        // need to actually implement this thing
        String pin = "2345";
        if (pin.length() > PIN_LENGTH) {
            throw new RuntimeException("pin bad");
        }
        return pin;
    }


    // TODO should be part of another class
    private Void setStoredPin(String pin) {
        // PinToTest
        return null;
    }

    private void removeFromPin() {
        if (pinToTest.length() >= 1) {
            pinToTest = pinToTest.substring(0, pinToTest.length() - 1);
        }
    }

    private void end() {
        if (saveCheck.equals(PinPageState.SAVE)) {
            checkEnd();
        } else {
            saveEnd();
        }
    }

    private void saveEnd() {
        if (getStoredPin().equals("")) {
            setStoredPin(pinToTest);
            Toast.makeText(this, "please enter the pin again", Toast.LENGTH_SHORT).show();
            resetPinPage();
            return;
        } else if (getStoredPin().equals(pinToTest)) {
            finishPinPage();
            return;
        }
        setStoredPin("");
        badPinAnimation();
        resetPinPage();
    }

    private void badPinAnimation() {
        Toast.makeText(this, "not the same pin", Toast.LENGTH_SHORT).show();
        // TODO add a failure thing here if they get it wrong
    }

    private void resetPinPage() {
        pinToTest = "";
        updateDisplay();
    }

    private void finishPinPage() {
        Intent intent = new Intent();
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    private void checkEnd() {
        if (pinToTest.equals(getStoredPin())) {
            finishPinPage();
        } else {
            badPinAnimation();
            resetPinPage();
        }
    }

    public enum PinPageState implements Serializable {
        SAVE,
        CHECK
    }
}