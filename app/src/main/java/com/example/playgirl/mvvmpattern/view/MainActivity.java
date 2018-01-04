package com.example.playgirl.mvvmpattern.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.playgirl.mvvmpattern.R;
import com.example.playgirl.mvvmpattern.data.AppUtils;
import com.example.playgirl.mvvmpattern.data.UserService;
import com.example.playgirl.mvvmpattern.model.AllData;
import com.example.playgirl.mvvmpattern.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    private ArrayList<User> listUser = new ArrayList<>();
    private UserService userService;
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userService = AppUtils.getSOService();
        getAllUser(this);
//
        recyclerView = findViewById(R.id.recy);


        userAdapter = new UserAdapter(new ArrayList<User>());
        userAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private AllData allData;

    public void getAllUser(final Context context) {

        userService.getAllData().enqueue(new Callback<AllData>() {
            @Override
            public void onResponse(Call<AllData> call, Response<AllData> response) {
                allData = response.body();
                listUser.addAll(allData.getResults());

                userAdapter.setListUser(listUser);
                userAdapter.notifyDataSetChanged();


//                userAdapter = new UserAdapter(listUser);
//                userAdapter.notifyDataSetChanged();
//                recyclerView.setAdapter(userAdapter);
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//
                Log.d(TAG, "size resoponse : " + listUser.size());

            }

            @Override
            public void onFailure(Call<AllData> call, Throwable t) {
                Log.d(TAG, "error : " + t.getMessage());
            }
        });
        Log.d(TAG, "size : " + listUser.size());

    }
}
