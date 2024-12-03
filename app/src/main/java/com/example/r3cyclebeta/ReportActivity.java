package com.example.r3cyclebeta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);


        Button reportBugsButton = findViewById(R.id.button2);
        reportBugsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the reportBugs method
                reportBugs(v);
            }
        });
    }

    // Method triggered by the button click
    public void reportBugs(View view) {
        // Get the text from the EditText (multiline text input for the report)
        EditText reportText = findViewById(R.id.editTextTextMultiLine);
        String reportContent = reportText.getText().toString().trim();

        if (reportContent.isEmpty()) {
            // Show a toast message if no content is entered
            Toast.makeText(this, "Please provide a bug report.", Toast.LENGTH_SHORT).show();
        } else {

            // For now, just show a confirmation toast
            Toast.makeText(this, "Report Submitted. Thank you!", Toast.LENGTH_SHORT).show();
            reportText.setText("");
        }
    }
}
