package com.androidhive.androidsqlite;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class AndroidSQLiteTutorialActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DatabaseHandler db = new DatabaseHandler(this);
        

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact(1170,"Person1", "995368765"));
        db.addContact(new Contact(1260,"Person2", "887659087"));
        db.addContact(new Contact(1320,"Person3", "987067543"));
        db.addContact(new Contact(1410,"Person4", "907856342"));
 
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();       
 
        for (Contact cn : contacts) {

            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                // Writing Contacts to log
        Log.d("Name: ", log);
        
        }
    }
}