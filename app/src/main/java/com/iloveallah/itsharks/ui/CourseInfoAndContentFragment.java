package com.iloveallah.itsharks.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.iloveallah.itsharks.R;
import com.iloveallah.itsharks.adapters.InfoContentTabsAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by I Love Allah on 05/30/2017.
 */

public class CourseInfoAndContentFragment extends Fragment {
    private ViewPager view;
    private ImageView image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.course_data_fragment, container, false);
        final CourseVariables variables = (CourseVariables) getArguments().getSerializable("my object");



        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) mainView.findViewById(R.id.collapsing_toolbar);

        collapsingToolbar.setTitle(variables.name);

        image = (ImageView) mainView.findViewById(R.id.image);
        Picasso.with(getActivity()).load(variables.imageID).into(image);


        TabLayout tableLayout = (TabLayout) mainView.findViewById(R.id.tab);
        view = (ViewPager) mainView.findViewById(R.id.view);

        tableLayout.addTab(tableLayout.newTab().setText("Info"));
        tableLayout.addTab(tableLayout.newTab().setText("Content"));
        tableLayout.setTabGravity(tableLayout.GRAVITY_FILL);
        InfoContentTabsAdapter adapter = new InfoContentTabsAdapter(getActivity().getSupportFragmentManager(), tableLayout.getTabCount());
        view.setAdapter(adapter);
        view.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tableLayout));
        tableLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                synchronized (tab) {

                }
            }
        });
        return mainView;
    }
}
