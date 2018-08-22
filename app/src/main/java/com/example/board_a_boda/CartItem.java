package com.example.board_a_boda;

public class CartItem {
    private String item_name;
    private  String item_price;
    private String item_number;
    private String itemtobuy;
    private  int photo;

    public CartItem() {
    }

    public CartItem(String item_name, String item_price, String item_number,String itemtobuy, int photo) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_number = item_number;
        this.itemtobuy =itemtobuy;
        this.photo = photo;
    }

    public String getItemtobuy() {
        return itemtobuy;
    }

    public int getPhoto() {
        return photo;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public String getItem_number() {
        return item_number;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public void setItem_number(String item_number) {
        this.item_number = item_number;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setItemtobuy(String itemtobuy) {
        this.itemtobuy = itemtobuy;
    }
}
