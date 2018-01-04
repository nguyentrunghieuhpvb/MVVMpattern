package com.example.playgirl.mvvmpattern.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.playgirl.mvvmpattern.R;
import com.example.playgirl.mvvmpattern.databinding.ActivityUserDetailBinding;
import com.example.playgirl.mvvmpattern.model.User;
import com.example.playgirl.mvvmpattern.viewmodel.UserDetailViewModel;


public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityUserDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail);

//        setSupportActionBar;
//        setSupportActionBar(binding.toolbar);
        User user = (User) getIntent().getSerializableExtra("user");

        if (user == null) {
            Log.d("xxx", "user null");
        }

        binding.setUserDetail(new UserDetailViewModel(user, this));

    }
}
