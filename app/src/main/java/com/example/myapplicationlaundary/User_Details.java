package com.example.myapplicationlaundary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class User_Details extends AppCompatActivity {
    EditText UserName,UserNumber,UserAddress;
    Button UserSubmitbutton;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        UserName=findViewById(R.id.UserName);
        UserNumber=findViewById(R.id.UserNumber);
        UserAddress=findViewById(R.id.UserAddress);
        UserSubmitbutton=findViewById(R.id.UserSubmitbutton);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("userdetails");


        UserSubmitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name =UserName.getText().toString().trim();
                String Number=UserNumber.getText().toString().trim();
                String Address=UserAddress.getText().toString().trim();
                String key=databaseReference.push().getKey();
                 databaseReference.push().child(key).child("UserName").setValue(Name);
                databaseReference.push().child(key).child("UserNumber").setValue(Number);
                databaseReference.push().child(key).child("UserAddress").setValue(Address);

            }
        });

    }

}