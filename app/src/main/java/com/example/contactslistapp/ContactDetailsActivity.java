package com.example.contactslistapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailsActivity extends AppCompatActivity {
    private TextView nameTextView, phoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details);

        nameTextView = findViewById(R.id.viewName);
        phoneTextView = findViewById(R.id.viewPhone);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("contact_name");
            String phone = intent.getStringExtra("contact_phone");
            nameTextView.setText("Name: " + name);
            phoneTextView.setText("Phone: " + phone);
        }
    }
}
