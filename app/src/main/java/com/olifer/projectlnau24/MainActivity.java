package com.olifer.projectlnau24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail;
    EditText etPassword;
    LinearLayout loginLayout;
    CheckBox chbRememberUser;
    Button btnLogin;
    SharedPreferences loginData;
    Button btnSignUp;

    final String LOGIN_TEXT = "Login";
    final String PASSWORD_TEXT = "Password";

    boolean validUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        loginLayout = findViewById(R.id.loginLayout);

        chbRememberUser = findViewById(R.id.chbRememberUser);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        validUser = false;

        btnLogin.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

        loadText();
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnLogin:

                validUser = true;
                if (TextUtils.isEmpty(etEmail.getText().toString()) || TextUtils.isEmpty(etPassword.getText().toString())) {
                    Toast.makeText(this, "Заповніть поля логіну та паролю!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    if (validUser) {
                        if (chbRememberUser.isChecked()){
                            saveText();
                        }
                        Intent intent = new Intent(this, ActionChoiceActivity.class);
                        startActivity(intent);
                    }

                }
                break;
            case R.id.btnSignUp:
                Intent signUpIntent = new Intent(this, SignUpActivity.class);
                startActivity(signUpIntent);
                break;
        }
    }

    void saveText() {
        loginData = getSharedPreferences("Login data", MODE_PRIVATE);
        SharedPreferences.Editor ed = loginData.edit();
        ed.putString(LOGIN_TEXT, etEmail.getText().toString());
        ed.putString(PASSWORD_TEXT, etPassword.getText().toString());
        ed.commit();
        /*
        If I want to create file with custom name (It will be MyPref in this case)
        Instead of getPreferences(MODE_PRIVATE) method we use getSharedPreferences("My pref", MODE_PRIVATE) method
         */
    }
    /*
    - Use getPreferences if we work with current Activity data and don't want to choose filename
    - Use getSharedPreferences if we save data which is common to multiple activities and choose filename for yourself
    */

    void loadText() {
        loginData = getSharedPreferences("Login data", MODE_PRIVATE);
        String savedLogin = loginData.getString(LOGIN_TEXT, "");
        String savedPassword = loginData.getString(PASSWORD_TEXT, "");
        etEmail.setText(savedLogin);
        etPassword.setText(savedPassword);
        /*
        If I want to load file with custom name (It will be MyPref in this case)
        Instead of getPreferences(MODE_PRIVATE) method we use getSharedPreferences("My pref", MODE_PRIVATE) method
         */
    }


}
