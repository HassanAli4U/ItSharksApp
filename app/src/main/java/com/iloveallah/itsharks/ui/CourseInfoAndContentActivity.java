package com.iloveallah.itsharks.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.iloveallah.itsharks.R;
import com.iloveallah.itsharks.adapters.InfoContentTabsAdapter;

public class CourseInfoAndContentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_tabs);
        CourseInfoAndContentFragment info = new CourseInfoAndContentFragment();

        info.setArguments(getIntent().getExtras().getBundle("data"));
        InfoContentTabsAdapter.infoFragment.setArguments(getIntent().getExtras().getBundle("data"));
        InfoContentTabsAdapter.contentFragment.setArguments(getIntent().getExtras().getBundle("data"));
        getSupportFragmentManager().beginTransaction().add(R.id.fdetail, info).commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();

    }
}
