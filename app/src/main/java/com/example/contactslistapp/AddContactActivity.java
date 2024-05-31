package com.example.contactslistapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {
    private EditText editName, editPhone, editAddress, editDob;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhoneNumber);
        editAddress = findViewById(R.id.editAddress);
        editDob = findViewById(R.id.editDob);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String phoneNumber = editPhone.getText().toString();
                String address = editAddress.getText().toString();
                String dob = editDob.getText().toString();

                if (!name.isEmpty() && !phoneNumber.isEmpty() && !address.isEmpty() && !dob.isEmpty()) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("name", name);
                    resultIntent.putExtra("phoneNumber", phoneNumber);
                    resultIntent.putExtra("address", address);
                    resultIntent.putExtra("dob", dob);
                    setResult(RESULT_OK, resultIntent);
                    finish();

                    // Show success message
                    Toast.makeText(AddContactActivity.this, "Contact added successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddContactActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
