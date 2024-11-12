package com.example.r3cyclebeta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class EncyclopediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia);

        // Initialize buttons
        Button mainButton = findViewById(R.id.homeBackButton);
        Button resourcesBackButton = findViewById(R.id.resourcesBackButton);

        // Set listeners for buttons
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EncyclopediaActivity.this, MainActivity.class));
            }
        });

        resourcesBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EncyclopediaActivity.this, ResourcesActivity.class));
            }
        });
    }
}
