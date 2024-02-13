package com.example.la_firsthad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    EditText email;
    EditText Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }


        email = findViewById(R.id.emailAddr);
        Pass = findViewById(R.id.enteredPass);
        loginButton = findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = email.getText().toString();
                String message2 = Pass.getText().toString();
                String FinalMessage = "Username: "+message+"Password: "+message2;
                Toast.makeText(MainActivity.this, FinalMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}





