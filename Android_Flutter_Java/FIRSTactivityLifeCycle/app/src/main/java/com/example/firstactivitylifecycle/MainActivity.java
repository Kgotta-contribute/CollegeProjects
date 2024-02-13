package com.example.firstactivitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText Email;
    EditText Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.email);
        loginButton = findViewById(R.id.loginBtn);
        Pass = findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = Email.getText().toString();
                String message2 = Pass.getText().toString();
                String FinalMessage = "Username: " + message + " Password : " + message2;
                Toast.makeText(MainActivity.this,FinalMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}