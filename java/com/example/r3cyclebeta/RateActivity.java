package com.example.r3cyclebeta;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RateActivity extends AppCompatActivity {

    private Button communityback;
    private Button playStoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        // Initialize buttons
        communityback = findViewById(R.id.communityback);
        playStoreButton = findViewById(R.id.playStoreButton);

        // Set listeners for buttons
        communityback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RateActivity.this, CommunityActivity.class));
            }
        });

        // Set listener for Play Store button
        playStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=YOUR_APP_PACKAGE_NAME"));
                startActivity(intent);
            }
        });
    }
}
