package com.vivek.sampleapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                List<Product> products = response.body();
                //Log.d("error", "products count" + products.size());
                Toast.makeText(Index1.this, "successful" + response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.d("error: ", "failed ");
                t.printStackTrace();
            }
        });
    }
}
