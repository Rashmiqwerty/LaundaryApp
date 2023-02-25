package com.example.myapplicationlaundary;

public class ContactModel {

    String shopName,shopOwnerName,shopAddress,shopNumber,shopImage;

    public ContactModel(String shopName, String shopOwnerName, String shopAddress, String shopNumber, String shopImage) {
        this.shopName = shopName;
        this.shopOwnerName = shopOwnerName;
        this.shopAddress = shopAddress;
        this.shopNumber = shopNumber;
        this.shopImage = shopImage;
    }


    public ContactModel() {
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopOwnerName() {
        return shopOwnerName;
    }

    public void setShopOwnerName(String shopOwnerName) {
        this.shopOwnerName = shopOwnerName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }
}
