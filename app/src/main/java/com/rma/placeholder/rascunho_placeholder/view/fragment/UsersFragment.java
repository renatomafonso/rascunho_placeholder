package com.rma.placeholder.rascunho_placeholder.view.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rma.placeholder.rascunho_placeholder.R;
import com.rma.placeholder.rascunho_placeholder.presentation.Presenter;
import com.rma.placeholder.rascunho_placeholder.presentation.User;
import com.rma.placeholder.rascunho_placeholder.view.UserAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private UserAdapter userAdapter;
    private Presenter presenter;


    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_user,container,false);

        mRecyclerView = view.findViewById(R.id.user_recycle);

        if( presenter == null ){
            presenter = new Presenter(this);
        }
        //presenter.setView( this );
        presenter.retrieveUsers( savedInstanceState );

        setupRecycler();
        Log.i("UsersActivity","onCreate");
        return view;
        //return inflater.inflate(R.layout.fragment_user, container, false);
    }

    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        userAdapter = new UserAdapter(new ArrayList<>(0));
        mRecyclerView.setAdapter(userAdapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        Log.i("UsersActivity","setupRecycler");
    }

    @Override
    public void onStart() {
        super.onStart();
        for(int i = 0; i< presenter.getUsers().size(); i++){
            User user = presenter.getUsers().get(i);
            userAdapter.updateList(user);
            userAdapter.notifyItemInserted(i);
        }
    }

    public void updateListaRecycler() {
        userAdapter.notifyDataSetChanged();
    }

    public void updateItemRecycler(int position){
        userAdapter.notifyItemChanged(position);
    }

}
