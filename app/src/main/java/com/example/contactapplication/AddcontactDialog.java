package com.example.contactapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class AddcontactDialog extends AppCompatDialogFragment {

     EditText editTextName, editTextNumber;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.addcontact_dialog, null);
        builder.setView(view)
                .setTitle("Add Contact")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username = editTextName.getText().toString();
                        String password = editTextNumber.getText().toString();
                        addContactNumber();

                    }
                });
        editTextName = view.findViewById(R.id.etName);
        editTextNumber = view.findViewById(R.id.etNumber);
        return builder.create();

    }

    public void addContactNumber () {
        String name = editTextName.getText().toString() ;
        String phone = editTextNumber.getText().toString() ;
        Intent contactIntent = new Intent(ContactsContract.Intents.Insert. ACTION ) ;
        contactIntent.setType(ContactsContract.RawContacts. CONTENT_TYPE ) ;
        contactIntent
                .putExtra(ContactsContract.Intents.Insert. NAME , name)
                .putExtra(ContactsContract.Intents.Insert. PHONE , phone) ;
        startActivityForResult(contactIntent , 1 ) ;
    }

}
