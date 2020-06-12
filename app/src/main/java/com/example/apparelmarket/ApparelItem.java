package com.example.apparelmarket;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class ApparelItem implements Serializable {
    private String itemId;
    private String itemCategory;
    private String itemPrice;
    private String itemName;
    private String itemDetail;
    private int[] itemImageAddr;

    public ApparelItem(String itemId, String itemCategory, String itemPrice, String itemName, String itemDetail, int[] itemImageAddr){
        this.itemId = itemId;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        this.itemDetail = itemDetail;
        this.itemImageAddr =  itemImageAddr;
    }

    public String getId(){
        return itemId;
    }
    public String getCategory(){
        return itemCategory;
    }
    public String getPrice(){
        return itemPrice;
    }
    public String getName() {
        return itemName;
    }
    public String getDetail(){
        return itemDetail;
    }
    public int[] getItemImage(){ return itemImageAddr; }

}