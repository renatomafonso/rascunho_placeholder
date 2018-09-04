package com.rma.placeholder.rascunho_placeholder.view;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rma.placeholder.rascunho_placeholder.R;
import com.rma.placeholder.rascunho_placeholder.presentation.Presenter;
import com.rma.placeholder.rascunho_placeholder.presentation.User;
import com.rma.placeholder.rascunho_placeholder.util.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private Presenter presenter;
    private ViewPager viewPager;
    private TabsAdapter tabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SlidingTabLayout slidingTabLayout = findViewById(R.id.st1_tabs);
        viewPager = findViewById(R.id.vp_pagina);

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorAccent));

        tabsAdapter = new TabsAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tabsAdapter);

        slidingTabLayout.setViewPager(viewPager);
    }

    /*public void usersActivity(View view){
        startActivity(new Intent(this,UsersActivity.class));
    }*/


}
