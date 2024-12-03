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

        //initialize buttons
        Button paperButton = findViewById(R.id.paperButton);
        Button cardboardButton = findViewById(R.id.cardboardButton);
        Button glassButton = findViewById(R.id.glassButton);
        Button plasticsButton = findViewById(R.id.plasticsButton);
        Button metalButton = findViewById(R.id.metalButton);

        //set listeners for buttons
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EncyclopediaActivity.this, PaperActivity.class));
            }
        });

        cardboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EncyclopediaActivity.this, CardboardActivity.class));
            }
        });

        glassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EncyclopediaActivity.this, GlassActivity.class));
            }
        });

        plasticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EncyclopediaActivity.this, PlasticsActivity.class));
            }
        });

        metalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EncyclopediaActivity.this, MetalActivity.class));
            }
        });
    }
}
