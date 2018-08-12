package com.example.board_a_boda;

public class ShopItem
{
    private String super_name;
    private String super_motto;
    private int photo;

    public ShopItem(int photo) {
        this.photo = photo;
    }

    public ShopItem(String super_name, String super_motto, int photo) {
        this.super_name = super_name;
        this.super_motto = super_motto;
        this.photo = photo;
    }

    public int getPhoto() {
        return photo;
    }

    public String getSuper_name() {
        return super_name;
    }

    public String getSuper_motto() {
        return super_motto;
    }

    public void setSuper_name(String super_name) {
        this.super_name = super_name;
    }

    public void setSuper_motto(String super_motto) {
        this.super_motto = super_motto;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
