package com.example.playgirl.mvvmpattern.model;

/**
 * Created by PlayGirl on 1/4/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Id implements Serializable{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}