package com.example.notificationsystem;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createContact = findViewById(R.id.createContact);
        Button displayContacts = findViewById(R.id.displayContacts);
        Button sendMessage = findViewById(R.id.sendMessage);

        createContact.setOnClickListener(this);
        displayContacts.setOnClickListener(this);
        sendMessage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.createContact:
                newContact(v);
                break;
            case R.id.displayContacts:
                displayContacts(v);
                break;
            case R.id.sendMessage:
                sendMessage(v);
                break;
        }
    }

    public static void main(String[] args) {
        contacts = new ArrayList<>();
    }

    public void newContact(View view) {

        EditText contactName = findViewById(R.id.contactName);
        EditText contactNumber = findViewById(R.id.contactNumber);

        int val = Integer.parseInt(contactNumber.getText().toString());

        Contact newContact = new Contact(contactName.getText().toString(), val);
        contacts.add(newContact);
    }

    public void displayContacts(View view) {
        TextView displayName = findViewById(R.id.displayName);
        TextView displayNumber = findViewById(R.id.displayNumber);

        displayName.setText("Name: " + contacts.get(0).getName());
        displayNumber.setText("Number: " + contacts.get(0).getNumber());
    }

    public void sendMessage(View view) {
        String txt = "Bitch be in danger";
        try {
            SmsManager smgr = SmsManager.getDefault();
            smgr.sendTextMessage(Integer.toString(contacts.get(0).getNumber()), null, txt, null, null);
            Toast.makeText(MainActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();

        }
    }
}
