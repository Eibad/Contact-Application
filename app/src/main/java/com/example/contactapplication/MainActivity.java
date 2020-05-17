package com.example.contactapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewContact;

    Button btnadd;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd = findViewById(R.id.btnADD);

        listViewContact = findViewById(R.id.listContact);

        GetContactsIntoArrayList();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddcontactDialog addcontactDialog = new AddcontactDialog();
                addcontactDialog.show(getSupportFragmentManager(), "Contact Dialog");
            }
        });

    }

    public void GetContactsIntoArrayList(){

        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);

        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone._ID};

        int[] to = {android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_2,cursor,from,to);
        listViewContact.setAdapter(simpleCursorAdapter);
        listViewContact.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

}


