package com.rma.placeholder.rascunho_placeholder.view;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rma.placeholder.rascunho_placeholder.view.fragment.UsersFragment;

public class TabsAdapter extends FragmentPagerAdapter {

    private String[] tabTitle = {"USERS"};

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment =  new UsersFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
