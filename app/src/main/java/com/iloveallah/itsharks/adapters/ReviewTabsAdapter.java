package com.iloveallah.itsharks.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.iloveallah.itsharks.ui.AddReviewFragment;
import com.iloveallah.itsharks.ui.ShowReviewFragment;

/**
 * Created by I Love Allah on 9/26/2016.
 */
public class ReviewTabsAdapter extends FragmentStatePagerAdapter {
    private final int num_tabs;

    public ReviewTabsAdapter(FragmentManager fm, int num_tabs) {
        super(fm);
        this.num_tabs = num_tabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case (0):
                AddReviewFragment addReviewFragment = new AddReviewFragment();
                return addReviewFragment;
            case (1):
                ShowReviewFragment showReviewFragment = new ShowReviewFragment();
                return showReviewFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num_tabs;
    }
}
