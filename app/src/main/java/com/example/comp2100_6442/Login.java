package com.example.comp2100_6442;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


//Tis class id dedicated for the activity of Logging in of a particular user with ID and Password


public class Login extends AppCompatActivity {

    EditText logUser;//UserName
    EditText logPass;//Password Specific to the User
    Button btnLogin;// Button for login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("LOG IN");

        logUser = findViewById(R.id.usernameInput1);
        logPass = findViewById(R.id.passwordInput1);
        btnLogin = findViewById(R.id.btnLogin2);

        logUser.addTextChangedListener(loginTextWatcher);
        logPass.addTextChangedListener(loginTextWatcher);
    }

    // Disabling the login button when the fields are not filled
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String userInput2 = logUser.getText().toString().trim();
            String passInput2 = logPass.getText().toString().trim();

            btnLogin.setEnabled(!userInput2.isEmpty() && !passInput2.isEmpty());

            if(logUser.length() == 0) {
                logUser.setError("Please enter username");
            }
            else if(logPass.length() == 0) { //checking for password length
                logPass.setError("Please enter password");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public void login2Pressed(View view) {
        String logInUser = logUser.getText().toString();
        String logInPass = logPass.getText().toString();

        SharedPreferences preferences = getSharedPreferences("PREFS", MODE_PRIVATE);

        // Get key-data from shared preferences
        String loginInfo = preferences.getString(logInUser + logInPass + "data", "Wrong Username or Email");
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("show", loginInfo);
        edit.commit();

        Intent surveryList = new Intent(getApplicationContext(), StartSurvey.class);
        startActivity(surveryList);


    }
}
