package com.example.board_a_boda;

public class HistoryItem
{
    private String super_name_text;
    private String date_text;
    private String receipt_text;
    private int photo;

    public HistoryItem()
    {
    }

    public HistoryItem(String super_name_text, String date_text, String receipt_text,int photo) {
        this.super_name_text = super_name_text;
        this.date_text = date_text;
        this.receipt_text = receipt_text;
        this.photo = photo;
    }

    public int getPhoto() {
        return photo;
    }

    public String getSuper_name_text() {
        return super_name_text;
    }

    public String getDate_text() {
        return date_text;
    }

    public String getReceipt_text() {
        return receipt_text;
    }

    public void setSuper_name_text(String super_name_text) {
        this.super_name_text = super_name_text;
    }

    public void setDate_text(String date_text) {
        this.date_text = date_text;
    }

    public void setReceipt_text(String receipt_text) {
        this.receipt_text = receipt_text;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
