package com.vivek.sampleapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Index1 extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Product> products;


    private OkHttpClient getClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();
        return client;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index1);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.83:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();

        APIInterface service = retrofit.create(APIInterface.class);

        Call<List<Product>> call = service.listproducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                 products = response.body();

                //int i = Integer.parseInt(null);
               // Product product = products.get(i);
                //Log.d("error", "products count" + products.size());

                Toast.makeText(Index1.this, "successful" , Toast.LENGTH_LONG).show();
                setProductsToAdapter();

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.d("error: ", "failed ");
                t.printStackTrace();
            }
        });
    }
    private void setProductsToAdapter(){
        mAdapter = new Newadpater(products, this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

}
