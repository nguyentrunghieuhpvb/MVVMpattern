package com.example.playgirl.mvvmpattern.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.example.playgirl.mvvmpattern.model.User;
import com.squareup.picasso.Picasso;

/**
 * Created by PlayGirl on 1/4/2018.
 */

public class UserDetailViewModel {

    private User user;
    private Context context;

    public UserDetailViewModel(User user, Context context) {
        this.user = user;
        this.context = context;
    }

    public String getAvatar() {
        return user.getPicture().getLarge();
    }

    public String getName() {
        return user.getName().getFirst() + " " + user.getName().getLast();
    }

    public String getPhone() {
        return user.getPhone();
    }

    public String getId() {
        return user.getId().getValue();
    }

    @BindingAdapter("bind:imageUrl")
    public static void setAvatar(ImageView img, String url) {
        Picasso.with(img.getContext()).load(url).into(img);
    }
}
