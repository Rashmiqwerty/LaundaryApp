package com.example.myapplicationlaundary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Shop_Item_List_Activity extends AppCompatActivity {
    EditText Shirtedittext,Jeansedittext,Sareeedittext,Suitedittext,Kurtaedittext;
    Button placeorder;
    int ShirtCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_item_list);
        Shirtedittext=(EditText) findViewById(R.id.Shirtedittext);
    }
    public void Shirtincrement(View v)
    {
        ShirtCount++;
        Shirtedittext.setText(""+ShirtCount);
    }
    public void Shirtdecrement(View v)
    {
        if(ShirtCount<=0)
            ShirtCount=0;
        else
        {
            ShirtCount--;
            Shirtedittext.setText(""+ShirtCount);
        }
    }
}