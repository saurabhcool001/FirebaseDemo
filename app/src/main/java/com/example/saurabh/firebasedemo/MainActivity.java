package com.example.saurabh.firebasedemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabaseName, mDatabaseEmail;

    private TextView mNameField, mEmailField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabaseName = FirebaseDatabase.getInstance().getReference().child("Name");
        mDatabaseEmail = FirebaseDatabase.getInstance().getReference().child("Email");
        mNameField = (TextView) findViewById(R.id.name_Field);
        mEmailField = (TextView) findViewById(R.id.emailField);

        mDatabaseName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue().toString();
                mNameField.setText("Name : " + name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabaseEmail.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String email = dataSnapshot.getValue().toString();
                mEmailField.setText("Email : " + email);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    ;
}
