package com.example.contactslistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class ContactDetailsActivity extends AppCompatActivity {
    private TextView profileLetter, viewName, viewPhone, viewAddress, viewDob;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle(null);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String phoneNumber = bundle.getString("phoneNumber");
        String address = bundle.getString("address");
        String dob = bundle.getString("dob");

        profileLetter = findViewById(R.id.profileLetter);
        viewName = findViewById(R.id.viewName);
        viewPhone = findViewById(R.id.viewPhone);
        viewAddress = findViewById(R.id.viewAddress);
        viewDob = findViewById(R.id.viewDob);

        profileLetter.setText(name.substring(0, 1));
        viewName.setText("Name: " + name);
        viewPhone.setText("Phone Number: " + phoneNumber);
        viewAddress.setText("Address: " + address);
        viewDob.setText("Date of Birth: " + dob);
    }
}