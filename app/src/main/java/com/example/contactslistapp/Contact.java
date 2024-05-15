package com.example.contactslistapp;

public class Contact {
    private String name;
    private String phoneNumber;
    private String address;
    private String dob;

    public Contact(String name, String phoneNumber, String address, String dob) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Character getprofileLetter(){
        return name.charAt(0);
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}


