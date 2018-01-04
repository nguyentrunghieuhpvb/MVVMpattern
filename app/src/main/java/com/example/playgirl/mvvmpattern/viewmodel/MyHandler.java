package com.example.playgirl.mvvmpattern.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.playgirl.mvvmpattern.model.User;
import com.example.playgirl.mvvmpattern.view.MainActivity;
import com.example.playgirl.mvvmpattern.view.UserDetailActivity;

/**
 * Created by PlayGirl on 1/4/2018.
 */

public class MyHandler {

    private Context context;
    private User user;

    public MyHandler(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    public void changeActivity() {
        Log.d("xxx", "click to view user detail");
        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

}
