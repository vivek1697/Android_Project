package com.vivek.sampleapi;


import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vivek on 1/30/2018.
 */

public interface APIInterface {



        @GET("products/index.json")
        Call<JsonObject> getProductlist();

    @GET("products/index1.json")
    Call<List<Product>> listproducts();
 }

