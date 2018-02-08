package com.vivek.sampleapi;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vivek on 2/8/2018.
 */

public class Reviewsadpater extends RecyclerView.Adapter<Reviewsadpater.ViewHolder> {
    public List<Review> reviews;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv1;
        static TextView userName;
       // static TextView userRating;
        static TextView userBody;

        public ViewHolder(View itemView1) {
            super(itemView1);
            cv1 = itemView1.findViewById(R.id.cv);
            userName = itemView1.findViewById(R.id.user_name);
            //userRating = itemView1.findViewById(R.id.user_rating);
            userBody = itemView1.findViewById(R.id.user_body);
        }
    }



    public Reviewsadpater(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public Reviewsadpater.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vh_review,viewGroup,false);
        ViewHolder vh = new ViewHolder(itemView1);
        return vh;
    }

    @Override
    public void onBindViewHolder(Reviewsadpater.ViewHolder holder, int i) {
        Review review = reviews.get(i);
        ViewHolder.userName.setText(review.user);
        //ViewHolder.userRating.setText(review.rating);
        ViewHolder.userBody.setText(review.body);

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
