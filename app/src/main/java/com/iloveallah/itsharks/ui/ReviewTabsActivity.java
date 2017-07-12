package com.iloveallah.itsharks.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.iloveallah.itsharks.R;
import com.iloveallah.itsharks.adapters.ReviewTabsAdapter;

public class ReviewTabsActivity extends AppCompatActivity {

    private ViewPager view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_tabs);

        TabLayout tableLayout = (TabLayout) findViewById(R.id.tab);
        view = (ViewPager) findViewById(R.id.view);

        tableLayout.addTab(tableLayout.newTab().setText("Add review"));
        tableLayout.addTab(tableLayout.newTab().setText("Show review"));
        tableLayout.setTabGravity(tableLayout.GRAVITY_FILL);
        ReviewTabsAdapter adapter = new ReviewTabsAdapter(getSupportFragmentManager(), tableLayout.getTabCount());
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

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.courses: {
                Intent i = new Intent(getApplicationContext(), CoursesActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.instruct: {
                Intent i = new Intent(getApplicationContext(), InstructorsActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.reviews: {
                getCallingActivity();
                return true;
            }
            case R.id.location: {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://maps.google.com/maps?q=29.961962,31.250072");
                i.setData(uri);
                startActivity(i);
                return true;
            }
            case R.id.contact: {

                Intent i = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(i);
                return true;
            }
            default: {
                Toast.makeText(ReviewTabsActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                return true;
            }
        }
    }
}
