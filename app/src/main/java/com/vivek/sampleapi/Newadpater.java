package com.vivek.sampleapi;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static com.vivek.sampleapi.Newadpater.ViewHolder.reviewsRecyclerView;

/**
 * Created by Vivek on 2/7/2018.
 */

public class Newadpater extends RecyclerView.Adapter<Newadpater.ViewHolder> {
    private final Context context;
    private RecyclerView.Adapter reviewsAdapter;
    private List<Product> products;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private  LinearLayout llfirstHolder;
        CardView cv;
        static TextView productName;
        static TextView productPrice;
        static RecyclerView reviewsRecyclerView;


        public ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            reviewsRecyclerView = itemView.findViewById(R.id.reviews_recycler_view);
            llfirstHolder = (LinearLayout)itemView.findViewById(R.id.ll_firstHolder);
        }
    }

    public Newadpater(List<Product> products, Context context) {
        this.products = products;
        this.context = context;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_product,viewGroup, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Product product = products.get(i);

        ViewHolder.productName.setText(product.name);
        ViewHolder.productPrice.setText(product.price);
        //ViewHolder.reviewUser.setText((products.get(i)));

        // Show Reviews in a recycler view
        List<Review> reviews = product.reviews;

        reviewsAdapter = new Reviewsadpater(reviews);
        reviewsRecyclerView.setAdapter(reviewsAdapter);
        reviewsAdapter.notifyDataSetChanged();

        LinearLayoutManager reviewsLayoutManager = new LinearLayoutManager(context);
        reviewsRecyclerView.setLayoutManager(reviewsLayoutManager);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
