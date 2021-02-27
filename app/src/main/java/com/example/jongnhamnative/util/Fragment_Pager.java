package com.example.jongnhamnative.util;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Fragment_Pager  extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;

    public Fragment_Pager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment_control myFragment = new Fragment_control();
        Bundle data = new Bundle();
        data.putInt("current_page", position+1);
        myFragment.setArguments(data);
        return myFragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
