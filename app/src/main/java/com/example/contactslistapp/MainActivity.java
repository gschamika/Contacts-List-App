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

        contactArrayList.add(new Contact("Kasun Perera", "076 458 6978", "15A, Vijaya Mawatha, Colombo 05"));
        contactArrayList.add(new Contact("Lahiru Madhushan", "076 782 1458", "42, Sunil Place, Galle"));
        contactArrayList.add(new Contact("Sithum Sampath", "071 236 1147", "7B, Mahinda Gardens, Kandy"));
        contactArrayList.add(new Contact("Prasad Kalhara", "078 014 7854", "29, Ranasinghe Lane, Negombo"));
        contactArrayList.add(new Contact("Navindu Pathum", "077 745 2236", "55/3, Senanayake Road, Anuradhapura"));
        contactArrayList.add(new Contact("Dilmi Sachintha", "077 230 4060", "18, Fernando Street, Matara"));
        contactArrayList.add(new Contact("Hasindu Dias", "071 555 7879", "103, Bandara Mawatha, Jaffna"));
        contactArrayList.add(new Contact("Wasana Gamage", "076 478 9621", "6/2, Perera Place, Ratnapura"));
        contactArrayList.add(new Contact("Kasuni Nimesha", "071 461 5596", "31A, Silva Lane, Kurunegala"));
        contactArrayList.add(new Contact("Apsara Madumali", "078 336 4587", "88, Gunaratne Road, Badulla"));
        contactArrayList.add(new Contact("Chamath Geeth", "077 714 5654", "12, Wickrama Mawatha, Polonnaruwa"));
        contactArrayList.add(new Contact("Chamindu Peris", "077 123 7856", "3C, Fernando Gardens, Batticaloa"));
        contactArrayList.add(new Contact("Anjana Hemal", "076 358 4040", "22/1, De Silva Avenue, Trincomalee"));
        contactArrayList.add(new Contact("Dilki Hansika", "078 321 4562", "45, Perera Street, Nuwara Eliya"));
        contactArrayList.add(new Contact("Amali Weerasinghe", "072 364 7921", "9/4, Rajapaksa Road, Ampara"));
        contactArrayList.add(new Contact("Isuru Lakshan", "071 305 4786", "63, Mendis Lane, Hambantota"));
        contactArrayList.add(new Contact("Nethmi Sanjana", "077 899 4531", "17A, Fernando Place, Kalutara"));
        contactArrayList.add(new Contact("Nuwan Prasad", "076 789 6358", "8B, Perera Gardens, Matale"));
        contactArrayList.add(new Contact("Rashmi Kalpana", "076 004 8931", "25, Gunasekara Road, Vavuniya"));
        contactArrayList.add(new Contact("Lahiru Malshan", "071 796 1245", "77, Silva Mawatha, Puttalam"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(contactArrayList, this);
        recyclerView.setAdapter(adapter);

    }
}

