package com.vivek.sampleapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Index extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TextView responseText;
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        responseText = findViewById(R.id.my_recycler_view);
        //mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(mLayoutManager);
        //Adapter = new MyAdapter(myDataset);
        //mRecyclerView.setAdapter(mAdapter);
        getProducts();
    }
    private void getProducts(){
        Call<JsonObject> productListCall  =   APIClient.getRetrofitService().getProductlist();
        productListCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response){

                if(response.isSuccessful()){
                    JsonObject jsonObject = response.body();

                    products = new Gson().fromJson(jsonObject.getAsJsonArray("products"),new TypeToken<List<Product>>() {}.getType());


                    Toast.makeText(Index.this, "successful" + response.body().toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(Index.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
