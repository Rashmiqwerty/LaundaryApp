package com.example.myapplicationlaundary;

public class ContactModel {

    String shopName,shopOwnerName,shopAddress,shopImage;
    long shopNumber,itemSareePrice,itemKurtaPrice,itemShirtPrice,itemJeansPrice,itemSuitPrice;

    public ContactModel(String shopName, String shopOwnerName, String shopAddress, String shopImage, long shopNumber, long itemSareePrice, long itemKurtaPrice, long itemShirtPrice, long itemJeansPrice, long itemSuitPrice) {
        this.shopName = shopName;
        this.shopOwnerName = shopOwnerName;
        this.shopAddress = shopAddress;
        this.shopImage = shopImage;
        this.shopNumber = shopNumber;
        this.itemSareePrice = itemSareePrice;
        this.itemKurtaPrice = itemKurtaPrice;
        this.itemShirtPrice = itemShirtPrice;
        this.itemJeansPrice = itemJeansPrice;
        this.itemSuitPrice = itemSuitPrice;
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

    public long getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(long shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public long getItemSareePrice() {
        return itemSareePrice;
    }

    public void setItemSareePrice(long itemSareePrice) {
        this.itemSareePrice = itemSareePrice;
    }

    public long getItemKurtaPrice() {
        return itemKurtaPrice;
    }

    public void setItemKurtaPrice(long itemKurtaPrice) {
        this.itemKurtaPrice = itemKurtaPrice;
    }

    public long getItemShirtPrice() {
        return itemShirtPrice;
    }

    public void setItemShirtPrice(long itemShirtPrice) {
        this.itemShirtPrice = itemShirtPrice;
    }

    public long getItemJeansPrice() {
        return itemJeansPrice;
    }

    public void setItemJeansPrice(long itemJeansPrice) {
        this.itemJeansPrice = itemJeansPrice;
    }

    public long getItemSuitPrice() {
        return itemSuitPrice;
    }

    public void setItemSuitPrice(long itemSuitPrice) {
        this.itemSuitPrice = itemSuitPrice;
    }
}
