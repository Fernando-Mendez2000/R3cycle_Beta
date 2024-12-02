package com.example.r3cyclebeta;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CommunityActivity extends AppCompatActivity {

    private Button aboutusButton;
    private Button ratethisappButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        // Initialize buttons
        aboutusButton = findViewById(R.id.aboutusButton);
        ratethisappButton = findViewById(R.id.ratethisappButton);

        // Set listeners for buttons
        aboutusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommunityActivity.this, AboutActivity.class));
            }
        });

        ratethisappButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAppStorePage();
            }
        });
    }

    // Method to open the Google Play Store app page for rating
    private void openAppStorePage() {
        try {
            // Redirect to Play Store
            String playStoreUrl = "market://details?id=" + getPackageName();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(playStoreUrl));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception e) {
            // If the Play Store app isn't installed, open in the browser
            String browserUrl = "https://play.google.com/store/apps/details?id=" + getPackageName();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(browserUrl));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
