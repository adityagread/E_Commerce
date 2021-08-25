package com.example.ecommerce;

public class Items {
    String iten_name, item_discription,item_image;
    int quantity,price;

    public Items() {    }

    public Items(String iten_name, String item_discription, String item_image, int quantity, int price) {
        this.iten_name = iten_name;
        this.item_discription = item_discription;
        this.item_image = item_image;
        this.quantity = quantity;
        this.price = price;
    }

    public String getIten_name() {
        return iten_name;
    }

    public String getItem_discription() {
        return item_discription;
    }

    public int getQuantity() {return quantity;}

    public int getPrice() {
        return price;
    }

    public String getItem_image() {
        return item_image;
    }

    public void setIten_name(String iten_name) {
        this.iten_name = iten_name;
    }

    public void setItem_discription(String item_discription) {
        this.item_discription = item_discription;
    }

    public void setItem_image(String item_image) {
        this.item_image = item_image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
