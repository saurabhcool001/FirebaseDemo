package com.example.saurabh.firebasedemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button mFirebaseBtn;
    private EditText mValueField;
    private EditText mEmailId;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseBtn = (Button) findViewById(R.id.firebaseBtn);
        mValueField = (EditText) findViewById(R.id.valueField);
        mEmailId = (EditText) findViewById(R.id.emailId);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Step 1: Create child in root object
                //Step 2: Assign some value to the child object

                String name = mValueField.getText().toString().trim();
                String email = mEmailId.getText().toString().trim();

                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("Name", name);
                hashMap.put("Email", email);
//                mDatabase.push().setValue(hashMap);
                mDatabase.push().setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Data Stored", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

//                mDatabase.child("Name").setValue(value);

//                mDatabase.push().setValue(value);
            }
        });
    }
}
