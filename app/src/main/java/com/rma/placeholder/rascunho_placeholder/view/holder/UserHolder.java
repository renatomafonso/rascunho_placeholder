package com.rma.placeholder.rascunho_placeholder.view.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rma.placeholder.rascunho_placeholder.R;

public class UserHolder extends RecyclerView.ViewHolder {

    private TextView textUser;

    public UserHolder(@NonNull View itemView) {
        super(itemView);
        textUser = itemView.findViewById(R.id.textView_user);
    }

    public void setTextUser(String user){
        textUser.setText(user);
    }
}
