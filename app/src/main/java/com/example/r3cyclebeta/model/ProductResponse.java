package com.example.r3cyclebeta.model;

import com.google.gson.annotations.SerializedName;

public class ProductResponse {

    @SerializedName("product")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
