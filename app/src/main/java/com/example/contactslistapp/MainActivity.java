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

        contactArrayList.add(new Contact("Kasun Perera", "076 458 6978", "15A, Vijaya Mawatha, Colombo 05", "January 12, 1999"));
        contactArrayList.add(new Contact("Lahiru Madhushan", "076 782 1458", "42, Sunil Place, Galle", "March 5, 1998"));
        contactArrayList.add(new Contact("Sithum Sampath", "071 236 1147", "7B, Mahinda Gardens, Kandy", "July 23, 1999"));
        contactArrayList.add(new Contact("Prasad Kalhara", "078 014 7854", "29, Ranasinghe Lane, Negombo", "November 8, 1998"));
        contactArrayList.add(new Contact("Navindu Pathum", "077 745 2236", "55/3, Senanayake Road, Anuradhapura", "April 17, 2000"));
        contactArrayList.add(new Contact("Dilmi Sachintha", "077 230 4060", "18, Fernando Street, Matara", "August 29, 1998"));
        contactArrayList.add(new Contact("Hasindu Dias", "071 555 7879", "103, Bandara Mawatha, Jaffna", "February 3, 1999"));
        contactArrayList.add(new Contact("Wasana Gamage", "076 478 9621", "6/2, Perera Place, Ratnapura", "June 20, 1998"));
        contactArrayList.add(new Contact("Kasuni Nimesha", "071 461 5596", "31A, Silva Lane, Kurunegala", "December 11, 1999"));
        contactArrayList.add(new Contact("Apsara Madumali", "078 336 4587", "88, Gunaratne Road, Badulla", "May 6, 1998"));
        contactArrayList.add(new Contact("Chamath Geeth", "077 714 5654", "12, Wickrama Mawatha, Polonnaruwa", "September 27, 1999"));
        contactArrayList.add(new Contact("Chamindu Peris", "077 123 7856", "3C, Fernando Gardens, Batticaloa", "January 19, 2000"));
        contactArrayList.add(new Contact("Anjana Hemal", "076 358 4040", "22/1, De Silva Avenue, Trincomalee", "March 14, 1998"));
        contactArrayList.add(new Contact("Dilki Hansika", "078 321 4562", "45, Perera Street, Nuwara Eliya", "July 7, 1999"));
        contactArrayList.add(new Contact("Amali Weerasinghe", "072 364 7921", "9/4, Rajapaksa Road, Ampara", "November 25, 1998"));
        contactArrayList.add(new Contact("Isuru Lakshan", "071 305 4786", "63, Mendis Lane, Hambantota", "April 9, 2000"));
        contactArrayList.add(new Contact("Nethmi Sanjana", "077 899 4531", "17A, Fernando Place, Kalutara", "August 2, 1998"));
        contactArrayList.add(new Contact("Nuwan Prasad", "076 789 6358", "8B, Perera Gardens, Matale", "February 23, 1999"));
        contactArrayList.add(new Contact("Rashmi Kalpana", "076 004 8931", "25, Gunasekara Road, Vavuniya", "June 15, 1998"));
        contactArrayList.add(new Contact("Lahiru Malshan", "071 796 1245", "77, Silva Mawatha, Puttalam", "October 4, 1999"));

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
