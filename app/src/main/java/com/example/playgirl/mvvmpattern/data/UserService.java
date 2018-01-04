package com.example.playgirl.mvvmpattern.data;

import com.example.playgirl.mvvmpattern.model.AllData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by PlayGirl on 1/4/2018.
 */

public interface UserService {
    @GET("?results=10&nat=en")
    Call<AllData> getAllData();
}
