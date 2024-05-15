package com.example.contactslistapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Contact> contactArrayList;
    private ArrayList<Contact> contactArrayListFull;
    private Context context;

    public RecyclerViewAdapter(ArrayList<Contact> contactArrayList, Context context) {
        this.contactArrayList = contactArrayList;
        this.context = context;
        contactArrayListFull = new ArrayList<>(contactArrayList);
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Contact contact = contactArrayList.get(position);
        holder.profileLetter.setText(contact.getprofileLetter().toString());
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhoneNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(context, ContactDetailsActivity.class);
                String name = contactArrayList.get(position).getName();
                String phoneNumber = contactArrayList.get(position).getPhoneNumber();
                String address = contactArrayList.get(position).getAddress();
                String dob = contactArrayList.get(position).getDob();
                intent.putExtra("name", name);
                intent.putExtra("phoneNumber", phoneNumber);
                intent.putExtra("address", address);
                intent.putExtra("dob", dob);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public Filter getFilter() {
        return contactFilter;
    }

    private Filter contactFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Contact> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(contactArrayListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Contact contact : contactArrayListFull) {
                    if (contact.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(contact);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            contactArrayList.clear();
            contactArrayList.addAll((ArrayList<Contact>) results.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView profileLetter, name, phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileLetter = itemView.findViewById(R.id.profileLetter);
            name = itemView.findViewById(R.id.name);
            phone = itemView.findViewById(R.id.phone);
        }
    }
}
