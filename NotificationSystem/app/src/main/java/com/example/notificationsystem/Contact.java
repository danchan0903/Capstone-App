package com.example.notificationsystem;

import android.text.Editable;

public class Contact {

    public String name;
    public int number;

    public Contact (String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName () {
        return name;
    }

    public int getNumber () {
        return number;
    }
}
