
package com.vivek.sampleapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("user")
    @Expose
    public String user;
    @SerializedName("rating")
    @Expose
    public Integer rating;
    @SerializedName("body")
    @Expose
    public String body;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
