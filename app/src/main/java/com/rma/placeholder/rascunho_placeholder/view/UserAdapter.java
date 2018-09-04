package com.rma.placeholder.rascunho_placeholder.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rma.placeholder.rascunho_placeholder.R;
import com.rma.placeholder.rascunho_placeholder.presentation.User;
import com.rma.placeholder.rascunho_placeholder.view.holder.UserHolder;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserHolder> {

    private List<User> users;

    public UserAdapter(ArrayList arrayListUsers) {
        users = arrayListUsers;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i("UsersAdapter","onCreateViewHolder");
        return new UserHolder(LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.user_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {
        Log.i("UsersAdapter","onBindViewHolder");
        userHolder.setTextUser(users.get(i).toString());
    }

    @Override
    public int getItemCount() {
        //return users != null ? users.size() : 0;
        if(users != null){
            Log.i("UsersAdapter","getItemCount - "+users.size());
            return users.size();
        }else{
            Log.i("UsersAdapter","getItemCount - 0");
            return 0;
        }
    }

    public void updateList(User user){
        insertItem(user);
    }

    public void clearList(){
        users.clear();
        notifyDataSetChanged();
    }

    private void insertItem(User user) {
        users.add(user);
        notifyItemInserted(getItemCount());
    }






}
