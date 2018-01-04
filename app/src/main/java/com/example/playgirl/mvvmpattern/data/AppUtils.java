package com.example.playgirl.mvvmpattern.data;

/**
 * Created by PlayGirl on 1/4/2018.
 */

public class AppUtils {

    public static final String BASE_URL = "https://api.randomuser.me/";

    public static UserService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}
