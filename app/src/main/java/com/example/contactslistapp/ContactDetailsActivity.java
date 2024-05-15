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
        String name = bundle.getString("name");
        String phoneNumber = bundle.getString("phoneNumber");
        String address = bundle.getString("address");

        profileLetter = findViewById(R.id.profileLetter);
        viewName = findViewById(R.id.viewName);
        viewPhone = findViewById(R.id.viewPhone);
        viewAddress = findViewById(R.id.viewAddress);

        profileLetter.setText(name.substring(0, 1));
        viewName.setText("Name: " + name);
        viewPhone.setText("Phone Number: " + phoneNumber);
        viewAddress.setText("Address: " + address);
    }
}