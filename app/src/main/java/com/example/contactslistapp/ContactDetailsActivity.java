package com.example.contactslistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactDetailsActivity extends AppCompatActivity {
    private TextView profileLetter, viewName, viewPhone, viewAddress;
    private Bundle bundle;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        bundle = getIntent().getExtras();
        message = bundle.getString("key");

        profileLetter = findViewById(R.id.profileLetter);
        viewName = findViewById(R.id.viewName);
        viewPhone = findViewById(R.id.viewPhone);
        viewAddress = findViewById(R.id.viewAddress);

        profileLetter.setText(message);
        viewName.setText("Name: " + message);
        viewPhone.setText("Phone Number: " + message);
        viewAddress.setText("Address: " + message);
    }
}