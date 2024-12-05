package com.example.r3cyclebeta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RateActivity extends AppCompatActivity {

    private Button communityback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        communityback = findViewById(R.id.communityback);
        communityback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RateActivity.this, CommunityActivity.class));
            }
        });

    }
}
