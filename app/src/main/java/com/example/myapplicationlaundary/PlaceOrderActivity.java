package com.example.myapplicationlaundary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class PlaceOrderActivity extends AppCompatActivity {

    private TextView textViewFinalPrice;
    private TextView textViewItems;
    private EditText editTextUserAddress;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        textViewFinalPrice=findViewById(R.id.finalPrice);
        textViewItems=findViewById(R.id.finalItems);
        editTextUserAddress=findViewById(R.id.userAddress);
        firebaseAuth = FirebaseAuth.getInstance();
        String totalPrice = getIntent().getStringExtra("totalPrice");
        String totalShirt = getIntent().getStringExtra("totalShirt");
        String totalJeans = getIntent().getStringExtra("totalJeans");
        String totalKurta = getIntent().getStringExtra("totalKurta");
        String totalSuit = getIntent().getStringExtra("totalSuit");
        String totalSaree = getIntent().getStringExtra("totalSaree");
        textViewFinalPrice.setText(totalPrice);
        textViewItems.setText("No. of Shirt: "+totalShirt+"\n"+"No. of Jeans: "+totalJeans
        +"\n"+"No. of Suit: "+totalSuit+"\n"+"No. of Saree: "+totalSaree+"\n"+"No. of Kurta: "+totalKurta);


    }
}