package com.iloveallah.itsharks.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.iloveallah.itsharks.ui.ContentFragment;
import com.iloveallah.itsharks.ui.InfoFragment;

/**
 * Created by I Love Allah on 9/22/2016.
 */
public class InfoContentTabsAdapter extends FragmentStatePagerAdapter {
    private final int num_tabs;
    public static InfoFragment infoFragment = new InfoFragment();
    public static ContentFragment contentFragment = new ContentFragment();

    public InfoContentTabsAdapter(FragmentManager fm, int num_tabs) {
        super(fm);
        this.num_tabs = num_tabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case (0):


                return infoFragment;
            case (1):

                return contentFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num_tabs;
    }
}
