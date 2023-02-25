package com.example.myapplicationlaundary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Dashboard2 extends AppCompatActivity {
   RecyclerView recyclerView;
   List<ContactModel> shopList;
    RecyclerContactAdapter adapter;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
        recyclerView=findViewById(R.id.recyclerView_dashboard);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setHasFixedSize(true);
       shopList=new ArrayList<>();

       adapter=new RecyclerContactAdapter(this,shopList);
       firebaseAuth=FirebaseAuth.getInstance();
//       String id= firebaseAuth.getCurrentUser().getUid();
       databaseReference= FirebaseDatabase.getInstance().getReference().child("shop");

       databaseReference.addChildEventListener(new ChildEventListener() {
                   @Override
                   public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                       ContactModel contactModel = snapshot.getValue(ContactModel.class);
                       shopList.add(contactModel);
                       adapter.notifyDataSetChanged();
                   }

                   @Override
                   public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                   }

                   @Override
                   public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                   }

                   @Override
                   public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError error) {

                   }
               });
//       recyclerView.setHasFixedSize(true);




        recyclerView.setAdapter(adapter);
    }
}