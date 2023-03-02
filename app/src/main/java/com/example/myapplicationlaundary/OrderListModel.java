package com.example.myapplicationlaundary;

public class OrderListModel {
     private String ItemName;
     private int Itemprice;

    public OrderListModel(String itemName, int itemprice) {
        ItemName = itemName;
        Itemprice = itemprice;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public void setItemprice(int itemprice) {
        Itemprice = itemprice;
    }

    public String getItemName() {
        return ItemName;
    }

    public int getItemprice() {
        return Itemprice;
    }
}

