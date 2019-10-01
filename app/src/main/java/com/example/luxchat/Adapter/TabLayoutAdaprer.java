package com.example.luxchat.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.luxchat.Fragment.FragmentAboutMe;
import com.example.luxchat.Fragment.FragmentGroup;
import com.example.luxchat.Fragment.FragmentOne;
import com.example.luxchat.UI.HomeActivity;

public class TabLayoutAdaprer extends FragmentStatePagerAdapter {
    private String listTittle[] = {"Messenger","Group Chat","About you"};
    private FragmentOne fragmentOne;
    private FragmentAboutMe fragmentAboutMe;
    private FragmentGroup fragmentGroup;
    public TabLayoutAdaprer(FragmentManager fm) {

        super(fm);
        fragmentOne = new FragmentOne();
        fragmentGroup = new FragmentGroup();
        fragmentAboutMe = new FragmentAboutMe();
    }

    @Override
    public Fragment getItem(int i) {
        if(i  == 0){
            return fragmentOne;
        }
        else if (i == 1){
            return  fragmentGroup;
        }
        else if(i == 2){
            return fragmentAboutMe;
        }
        else {}
        return null;
    }

    @Override
    public int getCount() {
        return listTittle.length;
    }



}
