package com.example.saurabh.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button mFirebaseBtn;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseBtn = (Button) findViewById(R.id.firebaseBtn);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Step 1: Create child in root object
                //Step 2: Assign some value to the child object

                mDatabase.child("Name").setValue("Saurabh");
            }
        });
    }
}
