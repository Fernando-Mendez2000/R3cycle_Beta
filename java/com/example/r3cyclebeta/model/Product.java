package com.example.r3cyclebeta.model;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("product_name")
    private String productName;

    @SerializedName("packaging")
    private String packaging;

    @SerializedName("lang")
    private String lang;

    // Getter methods
    public String getProductName() {
        return productName;
    }

    public String getPackaging() {
        return packaging;
    }

    public String getLang() {
        return lang;
    }
}
