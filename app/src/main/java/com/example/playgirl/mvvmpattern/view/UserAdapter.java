package com.example.playgirl.mvvmpattern.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.playgirl.mvvmpattern.R;
import com.example.playgirl.mvvmpattern.databinding.ItemUserBinding;
import com.example.playgirl.mvvmpattern.model.User;
import com.example.playgirl.mvvmpattern.viewmodel.ItemUserViewModel;
import com.example.playgirl.mvvmpattern.viewmodel.MyHandler;

import java.util.ArrayList;

/**
 * Created by PlayGirl on 1/4/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    ArrayList<User> listUser;
    Context context;

    public UserAdapter(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    public void setListUser(ArrayList<User> users) {
        this.listUser.clear();
        this.listUser.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        context = parent.getContext();
        ItemUserBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_user, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyHandler myHandler = new MyHandler(context, listUser.get(position));

        holder.binding.setHandler(myHandler);
        holder.binding.setUser(new ItemUserViewModel(listUser.get(position), context));

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemUserBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
