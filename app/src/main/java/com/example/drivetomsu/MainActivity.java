package com.example.drivetomsu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonDriveToMSU = findViewById(R.id.button_drive_to_msu);
        buttonDriveToMSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMSU();
            }
        });
    }

    private void navigateToMSU() {
        String destination = "Montclair State University, Montclair, NJ";
        Uri gmmIntentUri = Uri.parse("google.navigation:q=" + Uri.encode(destination) + "&mode=d");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}
