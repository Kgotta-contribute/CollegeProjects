package com.example.implicitintent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openUrlButton = findViewById(R.id.openUrlButton);
        Button sendEmailButton = findViewById(R.id.sendEmailButton);
        Button openMapsButton = findViewById(R.id.openMapsButton);
        Button sendSmsButton = findViewById(R.id.sendSmsButton); // Add this line

        openUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open a URL
                String url = "https://www.example.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Send an email
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:recipient@example.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "Email body");
                startActivity(intent);
            }
        });

        openMapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Maps for a specific location
                String location = "geo:0,0?q=latitude,longitude(label)";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                startActivity(intent);
            }
        });

        sendSmsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Send an SMS
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:7795825875")); // Replace with the recipient's phone number
                intent.putExtra("sms_body", "Hello, this is a test SMS."); // Message content
                startActivity(intent);
            }
        });
    }
}
