package com.example.webviewcheckbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // NEWLY ADDED BY ME
    // These lines declare two private member variables, webView of type WebView and checkBox of type CheckBox.
    private WebView webView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        checkBox = findViewById(R.id.checkbox);

        //These lines configure the WebView. It sets a WebViewClient to handle page navigation,
        //enables JavaScript, and loads a URL into the WebView.
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://github.com/Kgotta-Contribute");

        //This sets a listener for the CheckBox to react when its checked state changes. If the checkbox is checked, it calls the showAlertDialog method.
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                        showAlertDialog();
                    }
            }
        });

    }
    //These methods are lifecycle methods. They are called when the activity goes through different states.
    //In this case, a toast message is shown when the activity starts, resumes, pauses, stops, or is destroyed.
    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this, "ACTIVITY STARTED", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this, "ACTIVITY RESUMED", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this, "ACTIVITY PAUSED", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this, "ACTIVITY STOP", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this, "ACTIVITY DESTROYED", Toast.LENGTH_SHORT).show();
    }
    //This method creates and shows an AlertDialog with a message and an "OK" button. When the button is clicked,
    //it dismisses the dialog.
    private void showAlertDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Checkbox is checked!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}