package com.vivek.sampleapi;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vivek on 2/7/2018.
 */

public class Newadpater extends RecyclerView.Adapter<Newadpater.ViewHolder> {
    private List<Product> products;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        static TextView productName;
        static TextView productPrice;

       // public TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            //mTextView = (TextView) itemView;
        }
    }

    public Newadpater(List<Product> products) {
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_product,viewGroup, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        ViewHolder.productName.setText(products.get(i).name);
        ViewHolder.productPrice.setText(products.get(i).price);
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
