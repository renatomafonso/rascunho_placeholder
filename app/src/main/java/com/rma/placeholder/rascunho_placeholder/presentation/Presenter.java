package com.rma.placeholder.rascunho_placeholder.presentation;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.rma.placeholder.rascunho_placeholder.model.Model;
import com.rma.placeholder.rascunho_placeholder.view.fragment.UsersFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Presenter {

    private Model model;
    private UsersFragment view;
    private ArrayList<User> users = new ArrayList<>();

    public Presenter(UsersFragment view) {
        model = new Model(this);
        this.view = view;
    }

    public void updateItemRecycle(User user) {
        for( int i = 0; i < users.size(); i++ ){
            if( users.get(i).getId() == user.getId() ){
                view.updateItemRecycler( i );
                break;
            }
        }
    }

    public void updateListRecycler(ArrayList<User> u) {
        users.clear();
        users.addAll( u );
        view.updateListaRecycler();
    }

    public void showToast(String responseString) {
    }

    public UsersFragment getContext() {
        return view;
    }

    public void setView(UsersFragment usersActivity) {
        this.view = usersActivity;
    }

    public void retrieveUsers(Bundle savedInstanceState) {
        if( savedInstanceState != null ){
            users = savedInstanceState.getParcelableArrayList( "users" );
            return;
        }
        model.retrieveUsers();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void giveJsonArray(JSONArray jsonArrayUser) {
        try {
            for(int i=0;i<jsonArrayUser.length();i++){
                JSONObject jsonObject = jsonArrayUser.getJSONObject(i);
                String s = jsonObject.toString();
                users.add(new Gson().fromJson(s,User.class));
                Log.i("Presenter",s);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
