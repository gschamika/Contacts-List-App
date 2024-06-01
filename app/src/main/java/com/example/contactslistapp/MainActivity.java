package com.example.contactslistapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter adapter;
    private ArrayList<Contact> contactArrayList;
    private RecyclerView recyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactArrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerViewContacts);
        searchView = findViewById(R.id.searchView);
        ImageView add = findViewById(R.id.add);

        contactArrayList.add(new Contact("Sumudu Chamika", "077 922 6730", "12/3, Perera Lane, Galle", "July 18, 2000"));
        contactArrayList.add(new Contact("Prasad Sandeepa", "072 368 1789", "25A, Dharmapala Mawatha, Colombo 07", "March 5, 1999"));
        contactArrayList.add(new Contact("Kasuni Nimeka", "071 368 2258", "8B, Senanayake Road, Kandy", "July 23, 1999"));
        contactArrayList.add(new Contact("Lahiru Kaushan", "077 352 2223", "42, Fernando Place, Negombo", "November 8, 2000"));
        contactArrayList.add(new Contact("Nethma Perera", "078 778 7879", "6/1, Silva Gardens, Anuradhapura", "April 17, 2000"));
        contactArrayList.add(new Contact("Dilmi Sachintha", "071 502 4569", "33, Bandara Street, Matara", "August 29, 2001"));
        contactArrayList.add(new Contact("Isuru Lakshan", "071 305 4786", "63, Mendis Lane, Hambantota", "April 9, 2000"));
        contactArrayList.add(new Contact("Nethmi Sanjana", "077 899 4531", "17A, Fernando Place, Kalutara", "August 2, 1998"));
        contactArrayList.add(new Contact("Nuwan Prasad", "076 789 6358", "8B, Perera Gardens, Matale", "February 23, 1999"));
        contactArrayList.add(new Contact("Rashmi Kalpana", "076 004 8931", "25, Gunasekara Road, Vavuniya", "June 15, 1998"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(contactArrayList, this);
        recyclerView.setAdapter(adapter);

        // Set up search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        // Set up add button functionality
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
            String phoneNumber = data.getStringExtra("phoneNumber");
            String address = data.getStringExtra("address");
            String dob = data.getStringExtra("dob");

            Contact newContact = new Contact(name, phoneNumber, address, dob);
            contactArrayList.add(newContact);
            adapter.notifyDataSetChanged();
        }
    }

}