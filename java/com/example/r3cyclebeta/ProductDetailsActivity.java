package com.example.r3cyclebeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Retrieve data passed from ScannerActivity
        Intent intent = getIntent();
        String productName = intent.getStringExtra("name");
        String packaging = intent.getStringExtra("packaging");

        // Set product name and packaging to TextViews
        TextView productNameView = findViewById(R.id.productNameTextView);
        TextView packagingView = findViewById(R.id.packagingTextView);

        // Using string resources with placeholders to set the text
        productNameView.setText(getString(R.string.product_name, productName));
        packagingView.setText(getString(R.string.packaging_details, packaging));

        // Handle back button press to navigate to MainActivity
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                navigateToMainMenu();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    // Method to navigate to MainActivity
    private void navigateToMainMenu() {
        Intent intent = new Intent(ProductDetailsActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}
