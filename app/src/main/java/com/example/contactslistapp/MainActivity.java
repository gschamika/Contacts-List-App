package com.example.contactslistapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter adapter;
    private ArrayList<Contact> contactArrayList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactArrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerViewContacts);

        contactArrayList.add(new Contact("Kasun Perera", "076 458 6978", "123 Street, City"));
        contactArrayList.add(new Contact("Lahiru Madhushan", "076 782 1458", "123 Street, City"));
        contactArrayList.add(new Contact("Sithum Sampath", "071 236 1147", "123 Street, City"));
        contactArrayList.add(new Contact("Prasad Kalhara", "078 014 7854", "123 Street, City"));
        contactArrayList.add(new Contact("Navindu Pathum", "077 745 2236", "123 Street, City"));
        contactArrayList.add(new Contact("Dilmi Sachintha", "077 230 4060", "123 Street, City"));
        contactArrayList.add(new Contact("Hasindu Dias", "071 555 7879", "123 Street, City"));
        contactArrayList.add(new Contact("Wasana Gamage", "076 478 9621", "123 Street, City"));
        contactArrayList.add(new Contact("Kasuni Nimesha", "071 461 5596", "123 Street, City"));
        contactArrayList.add(new Contact("Apsara Madumali", "078 336 4587", "123 Street, City"));
        contactArrayList.add(new Contact("Chamath Geeth", "077 714 5654", "123 Street, City"));
        contactArrayList.add(new Contact("Chamindu Peris", "077 123 7856", "123 Street, City"));
        contactArrayList.add(new Contact("Anjana Hemal", "076 358 4040", "123 Street, City"));
        contactArrayList.add(new Contact("Dilki Hansika", "078 321 4562", "123 Street, City"));
        contactArrayList.add(new Contact("Amali Weerasinghe", "072 364 7921", "123 Street, City"));
        contactArrayList.add(new Contact("Isuru Lakshan", "071 305 4786", "123 Street, City"));
        contactArrayList.add(new Contact("Nethmi Sanjana", "077 899 4531", "123 Street, City"));
        contactArrayList.add(new Contact("Nuwan Prasad", "076 789 6358", "123 Street, City"));
        contactArrayList.add(new Contact("Rashmi Kalpana", "076 004 8931", "123 Street, City"));
        contactArrayList.add(new Contact("Lahiru Malshan", "071 796 1245", "123 Street, City"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(contactArrayList, this);
        recyclerView.setAdapter(adapter);
    }
}

