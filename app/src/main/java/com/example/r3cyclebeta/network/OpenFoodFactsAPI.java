package com.example.r3cyclebeta.network;

import com.example.r3cyclebeta.model.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenFoodFactsAPI {
    @GET("product/{barcode}.json")
    Call<ProductResponse> getProductInfo(@Path("barcode") String barcode, @Query("lc") String languageCode);
}
