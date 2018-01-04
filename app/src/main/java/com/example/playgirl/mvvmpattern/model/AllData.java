package com.example.playgirl.mvvmpattern.model;

/**
 * Created by PlayGirl on 1/4/2018.
 */

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllData {

    @SerializedName("results")
    @Expose
    private List<User> results = null;
    @SerializedName("info")
    @Expose
    private Info info;

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}