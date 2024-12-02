package com.example.r3cyclebeta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ResourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        Button termsOfUseButton = findViewById(R.id.termsOfUseButton);
        Button encyclopediaButton = findViewById(R.id.encyclopediaButton);
        Button educationButton = findViewById(R.id.educationButton);

        termsOfUseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResourcesActivity.this, TermsActivity.class));
            }
        });
        encyclopediaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResourcesActivity.this, EncyclopediaActivity.class));
            }
        });
        educationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResourcesActivity.this, EducationActivity.class));
            }
        });
    }
}