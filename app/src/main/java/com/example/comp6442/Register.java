package com.example.comp6442;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText username;
    EditText email;
    EditText password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setTitle("REGISTER");

        username = findViewById(R.id.usernameInput2);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput2);
        register = findViewById(R.id.btnRegister2);

        username.addTextChangedListener(registerTextWatcher);
        email.addTextChangedListener(registerTextWatcher);
        password.addTextChangedListener((registerTextWatcher));

    }

    private TextWatcher registerTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String userInput = username.getText().toString().trim();
            String emailInput = email.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();

            register.setEnabled(!userInput.isEmpty() && !emailInput.isEmpty() && !passwordInput.isEmpty());

            if(username.length() == 0) {
                username.setError("Please choose a username");
            }
            else if(email.length() == 0) {
                email.setError("Please enter email");
            }
            else if(password.length() == 0) {
                password.setError("Please choose a password");
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };



    public void register2Pressed(View view) {
        SharedPreferences preferences = getSharedPreferences("PREFS", MODE_PRIVATE);
        String createUsername = username.getText().toString();
        String createEmail = email.getText().toString();
        String createPassword = password.getText().toString();

        SharedPreferences.Editor editPref = preferences.edit();
        editPref.putString(createUsername + createPassword + "data", "Welcome " + createUsername);
        editPref.commit();

        Intent sendtoLogin = new Intent(getApplicationContext(), Login.class);
        startActivity(sendtoLogin);


        if((username.toString().trim().length() > 1 && email.toString().trim().length() > 1 && password.toString().trim().length() > 1)) {
            Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(Register.this, "Register Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

}
