package com.example.myapplicationlaundary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Shop_Item_List_Activity extends AppCompatActivity {
    Toolbar toolbar;

    TextView shirtPrice,suitPrice,sareePrice,jeansPrice,kurtaPrice;
    TextView shirtitemadd,total_number_of_Shirt,shirtitemminus,total_Shirt_price_Sum;
    TextView jeansitemadd,jeans_Quantity,jeansitemminus,total_Jeans_price_Sum;
    TextView suititemadd,suit_Quantity,suititemminus,total_Suit_price_Sum;
    TextView sareeitemadd,saree_Quantity,sareeitemminus,total_Saree_price_Sum;
    TextView kurtaitemadd,kurta_Quantity,kurtaitemminus,total_Kurta_price_Sum;
    TextView total_Sum;
    Button PlaceOrderButton;
    int ShirtCount=0;
    int SuitCount=0;int SareeCount=0;int KurtaCount=0;
    int JeansCount=0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_item_list);
        shirtPrice = findViewById(R.id.itemShirtPrice);
        suitPrice = findViewById(R.id.itemSuitPrice);
        sareePrice=findViewById(R.id.itemSareePrice);
        jeansPrice=findViewById(R.id.itemJeansPrice);
        kurtaPrice=findViewById(R.id.itemKurtaPrice);

        total_number_of_Shirt=findViewById(R.id.total_number_of_Shirt);
        shirtitemadd=findViewById(R.id.shirtitemadd);
        shirtitemminus=findViewById(R.id.shirtitemminus);
        total_Shirt_price_Sum=findViewById(R.id.total_Shirt_price_Sum);

        jeansitemadd=findViewById(R.id.jeansitemadd);
        jeans_Quantity=findViewById(R.id.jeans_Quantity);
        jeansitemminus=findViewById(R.id.jeansitemadd);
        total_Jeans_price_Sum=findViewById(R.id.total_Jeans_price_Sum);

        suititemadd=findViewById(R.id.suititemadd);
        suit_Quantity=findViewById(R.id.saree_Quantity);
        suititemminus=findViewById(R.id.suititemminus);
        total_Suit_price_Sum=findViewById(R.id.total_Suit_price_Sum);

        sareeitemadd=findViewById(R.id.sareeitemadd);
        saree_Quantity=findViewById(R.id.saree_Quantity);
        sareeitemminus=findViewById(R.id.suititemminus);
        total_Saree_price_Sum=findViewById(R.id.total_Saree_price_Sum);

        kurtaitemadd=findViewById(R.id.kurtaitemadd);
        kurta_Quantity=findViewById(R.id.kurta_Quantity);
        kurtaitemminus=findViewById(R.id.kurtaitemminus);
        total_Kurta_price_Sum=findViewById(R.id.total_Kurta_price_Sum);



        total_Sum=findViewById(R.id.total_Sum);
        PlaceOrderButton=findViewById(R.id.PlaceOrderButton);

        long shirt = getIntent().getLongExtra("shirt",0);
        shirtPrice.setText(String.valueOf(shirt));
        long suit=getIntent().getLongExtra("suit",0);
        suitPrice.setText(String.valueOf(suit));
        long saree=getIntent().getLongExtra("saree",0);
        sareePrice.setText(String.valueOf(saree));
        long kurta=getIntent().getLongExtra("kurta",0);
        kurtaPrice.setText(String.valueOf(kurta));
        long jeans=getIntent().getLongExtra("jeans",0);
        jeansPrice.setText(String.valueOf(jeans));

        shirtitemadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShirtCount++;
                total_number_of_Shirt.setText(" "+ShirtCount);


            }
        });
        shirtitemminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(ShirtCount<=0)
               {
                   ShirtCount=0;
               }
               else
               {
                   ShirtCount--;
               }
                total_number_of_Shirt.setText(" "+ShirtCount);
            }
        });

        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                int temp;
                int t=Integer.parseInt(shirtPrice.getText().toString());
                temp = ShirtCount * t;
                total_Shirt_price_Sum.setText(String.valueOf(temp));


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
     total_number_of_Shirt.addTextChangedListener(textWatcher);

     jeansitemadd.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             JeansCount++;
             jeans_Quantity.setText(" "+JeansCount);
         }
     });
     jeansitemminus.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(JeansCount<=0)
             {
                 JeansCount=0;
             }
             else
             {
                 JeansCount--;
             }
             jeans_Quantity.setText(" "+JeansCount);
         }
     });
     TextWatcher textWatcherJeans=new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

         }

         @Override
         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

             int temp;
             int t=Integer.parseInt(jeansPrice.getText().toString());
             temp=JeansCount * t;
             total_Jeans_price_Sum.setText(String.valueOf(temp));
         }

         @Override
         public void afterTextChanged(Editable editable) {

         }
     };
     jeans_Quantity.addTextChangedListener(textWatcherJeans);


        suititemadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SuitCount++;
                suit_Quantity.setText(" "+SuitCount);


            }
        });
        suititemminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SuitCount<=0)
                {
                    SuitCount=0;
                }
                else
                {
                    SuitCount--;
                }
                suit_Quantity.setText(" "+SuitCount);
            }
        });
        TextWatcher textWatcherSuit=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                int temp;
                int t=Integer.parseInt(suitPrice.getText().toString());
                temp = SuitCount * t;
                total_Suit_price_Sum.setText(String.valueOf(temp));


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        suit_Quantity.addTextChangedListener(textWatcherSuit);
        sareeitemadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SareeCount++;
                saree_Quantity.setText(" "+SareeCount);


            }
        });
        sareeitemminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SareeCount<=0)
                {
                    SareeCount=0;
                }
                else
                {
                   SareeCount--;
                }
                saree_Quantity.setText(" "+SareeCount);
            }
        });
        TextWatcher textWatcherSaree=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                int temp;
                int t=Integer.parseInt(sareePrice.getText().toString());
                temp = SareeCount * t;
                total_Saree_price_Sum.setText(String.valueOf(temp));


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        saree_Quantity.addTextChangedListener(textWatcherSaree);




        kurtaitemadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KurtaCount++;
                kurta_Quantity.setText(" "+KurtaCount);


            }
        });
        kurtaitemminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(KurtaCount<=0)
                {
                    KurtaCount=0;
                }
                else
                {
                    KurtaCount--;
                }
                kurta_Quantity.setText(" "+KurtaCount);
            }
        });
        TextWatcher textWatcherKurta=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                int temp;
                int t=Integer.parseInt(kurtaPrice.getText().toString());
                temp = KurtaCount * t;
                total_Kurta_price_Sum.setText(String.valueOf(temp));


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
       kurta_Quantity.addTextChangedListener(textWatcherKurta);

    }

}