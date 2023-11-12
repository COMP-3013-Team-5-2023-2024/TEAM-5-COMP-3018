package com.example.group_5_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText userNameEdt, dobEdt, ageEdt, pinEdt;
    private Button registerBtn;
    private DBHandler dbHandler;

    SharedPreferences userData;
    public boolean doesKeyExist(String key) {
        return userData.contains(key);
    }
    // setter for testing
    public void setUserData(SharedPreferences sharedPreferences) {
        this.userData = sharedPreferences;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // load shared preferences as user data
        Intent changeToLogin = new Intent(this, LoginActivity.class);
        userData = getSharedPreferences("userData", Context.MODE_PRIVATE);
        if (doesKeyExist("userName")){
            System.out.println("yes");
            startActivity(changeToLogin);
        }
        else{
            setContentView(R.layout.activity_main);
        }

        // initializing all our variables.
        userNameEdt = findViewById(R.id.idEdtUserName);
        ageEdt = findViewById(R.id.idEdtAge);
        dobEdt = findViewById(R.id.idEdtDob);
        pinEdt = findViewById(R.id.idEdtPin);
        registerBtn = findViewById(R.id.idBtnRegister);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);


        // below line is to add on click listener for our add course button.
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String userName = userNameEdt.getText().toString();
                String age = ageEdt.getText().toString();
                String dob = dobEdt.getText().toString();
                String pin = pinEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (userName.isEmpty() && dob.isEmpty() && age.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

//                // on below line we are calling a method to add new
//                // course to sqlite data and pass all our values to it.
                dbHandler.addFirstPeriod();

                // we will now save user data to the shared preferences
                SharedPreferences.Editor editor = userData.edit();
                editor.putString("userName", userName);
                editor.putString("dob", dob);
                editor.putString("age", age);
                editor.putString("pin", pin);
                editor.commit();


                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "User is added", Toast.LENGTH_SHORT).show();
//                userNameEdt.setText("");
//                ageEdt.setText("");
//                dobEdt.setText("");
                startActivity(changeToLogin);
            }
        });
    }
}