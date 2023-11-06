package com.example.group_5_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText firstNameEdt, lastNameEdt, userNameEdt, pinEdt, ageEdt;
    private Button registerBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        firstNameEdt = findViewById(R.id.idEdtFirstName);
        lastNameEdt = findViewById(R.id.idEdtLastName);
        userNameEdt = findViewById(R.id.idEdtUserName);
        ageEdt = findViewById(R.id.idEdtAge);
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
                String firstName = firstNameEdt.getText().toString();
                String lastName = lastNameEdt.getText().toString();
                String userName = userNameEdt.getText().toString();
                String age = ageEdt.getText().toString();
                String pin = pinEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (firstName.isEmpty() && lastName.isEmpty() && userName.isEmpty() && pin.isEmpty() && age.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewUser(userName, firstName, lastName, pin, age);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "User is added", Toast.LENGTH_SHORT).show();
                firstNameEdt.setText("");
                lastNameEdt.setText("");
                userNameEdt.setText("");
                ageEdt.setText("");
                pinEdt.setText("");
            }
        });
    }
}