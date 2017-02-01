package com.example.labs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME ="LoginActivity";
    SharedPreferences sharedPref;
    EditText loginEmail;
    EditText password;
    Button loginButton;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginEmail = (EditText)findViewById(R.id.editText);
        //password = (EditText)findViewById(R.id.editText2);
        loginButton = (Button)findViewById(R.id.button2);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String emailLogin = loginEmail.getText().toString();
                //String pwd = password.getText().toString();

                // setEmailKeyValue
                sharedPref = getPreferences(Context.MODE_PRIVATE);
                editor = sharedPref.edit();
                String key = getString(R.string.email);
                editor.putString(key, emailLogin);
                //editor.putString("Password", pwd);

                editor.commit();

                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });


        Log.i(ACTIVITY_NAME, "In onCreate()");
    }

    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onStart(){
        super.onStart();

        sharedPref = getPreferences(Context.MODE_PRIVATE);

        String key = getString(R.string.email);
        String existingEmail = sharedPref.getString(key, null);
        if (existingEmail != null){
            loginEmail.setText(existingEmail);
        } else {
            loginEmail.setText("email@domain.com");
        }
        //sharedPref = getApplicationContext().getSharedPreferences("storedEmail", Context.MODE_PRIVATE);
       // String userLogin = sharedPref.getString("login", null);
        //if (userLogin != null) {
        //String login = sharedPref.getString("loginEmail","email@domain.com");
        //}

        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}
