package com.example.r3cyclebeta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CommunityActivity extends AppCompatActivity {

    private Button aboutusButton;
    private Button reportBugsButton;
    private Button ratethisappButton;

    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);



        // Initialize buttons
        aboutusButton = findViewById(R.id.aboutusButton);
        reportBugsButton = findViewById(R.id.reportBugsButton);
        ratethisappButton = findViewById(R.id.ratethisappButton);
        homeButton = findViewById(R.id.homeButton);



// Set listeners for buttons
        aboutusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommunityActivity.this, AboutActivity.class));
            }
        });

        reportBugsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommunityActivity.this, ReportActivity.class));
            }
        });

        ratethisappButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommunityActivity.this, RateActivity.class));
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CommunityActivity.this, MainActivity.class));
            }
        });








    }






}
