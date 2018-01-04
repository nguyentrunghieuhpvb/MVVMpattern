package com.example.playgirl.mvvmpattern.viewmodel;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.example.playgirl.mvvmpattern.model.User;
import com.squareup.picasso.Picasso;

/**
 * Created by PlayGirl on 1/4/2018.
 */

public class ItemUserViewModel {

    private User user;
    private Context context;

    public ItemUserViewModel(User user, Context context) {
        this.user = user;
        this.context = context;
    }

    public String getName() {
        return user.getName().getLast() + " " + user.getName().getFirst();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getAvatarUrl() {
        return user.getPicture().getLarge();
    }

    @BindingAdapter("bind:avatarUrl")
    public static void setImageUrl(ImageView img, String url) {
        Picasso.with(img.getContext()).load(url).into(img);
    }
}
