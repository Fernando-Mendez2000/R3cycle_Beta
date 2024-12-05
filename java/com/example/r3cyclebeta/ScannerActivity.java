package com.example.r3cyclebeta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.r3cyclebeta.model.ProductResponse;
import com.example.r3cyclebeta.network.OpenFoodFactsAPI;
import com.example.r3cyclebeta.network.RetrofitClient;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        // Start the barcode scanner using ZXing
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scan a barcode to identify material for recycling");
        integrator.setCameraId(0);  // Use the default camera (rear)
        integrator.setBeepEnabled(true);
        integrator.setBarcodeImageEnabled(true);
        integrator.initiateScan();  // Initiate the scanning process
    }

    // Handle the result of the barcode scan
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                String barcode = result.getContents();  // Get the barcode value
                fetchProductData(barcode);  // Fetch product data based on the scanned barcode
            } else {
                // Show a message if no barcode is detected and navigate back to the main menu
                Toast.makeText(this, "No barcode detected. Returning to main menu.", Toast.LENGTH_LONG).show();
                navigateToMainMenu();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    // Fetch product information from Open Food Facts API
    private void fetchProductData(String barcode) {
        OpenFoodFactsAPI apiService = RetrofitClient.getClient().create(OpenFoodFactsAPI.class);
        Call<ProductResponse> call = apiService.getProductInfo(barcode, "en");

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ProductResponse productResponse = response.body();
                    String productName = productResponse.getProduct().getProductName();
                    String packaging = productResponse.getProduct().getPackaging();

                    if (productName == null || productName.isEmpty()) {
                        productName = "Unknown Product";
                    }
                    if (packaging == null || packaging.isEmpty()) {
                        packaging = "No packaging information available.";
                    }

                    // Create an intent to navigate to ProductDetailsActivity
                    Intent intent = new Intent(ScannerActivity.this, ProductDetailsActivity.class);
                    intent.putExtra("name", productName);
                    intent.putExtra("packaging", packaging);
                    startActivity(intent);
                    finish();  // Close ScannerActivity
                } else {
                    Toast.makeText(ScannerActivity.this, "Product not found. Returning to main menu.", Toast.LENGTH_LONG).show();
                    navigateToMainMenu();
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Toast.makeText(ScannerActivity.this, "Failed to retrieve product info. Returning to main menu.", Toast.LENGTH_LONG).show();
                navigateToMainMenu();
            }
        });
    }

    // Handle back button press to navigate to the main menu
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        navigateToMainMenu();
    }

    // Method to navigate to the Main Menu
    private void navigateToMainMenu() {
        Intent intent = new Intent(ScannerActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();  // Close ScannerActivity to prevent it from being in the back stack
    }
}
