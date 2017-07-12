package com.iloveallah.itsharks.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.iloveallah.itsharks.R;
import com.iloveallah.itsharks.adapters.InfoContentTabsAdapter;

//import android.support.annotation.NonNull;
//import android.support.annotation.RequiresApi;
//import com.firebase.ui.auth.AuthUI;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class CoursesActivity extends AppCompatActivity implements Listener {
    private boolean twoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        CoursesFragment fragment = new CoursesFragment();
        fragment.setListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.fmain, fragment).commit();
        if (null != findViewById(R.id.fdetail)) {
            twoPane = true;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.courses: {
                getCallingActivity();
                return true;
            }
            case R.id.instruct: {
                Intent i = new Intent(getApplicationContext(), InstructorsActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.reviews: {
                Intent i = new Intent(getApplicationContext(), ReviewTabsActivity.class);
                startActivity(i);
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
                Toast.makeText(CoursesActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                return true;
            }
        }
    }


    @Override
    public void response(CourseVariables variables) {
        if (!twoPane) {
            Intent intent = new Intent(getApplicationContext(), CourseInfoAndContentActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("my object", variables);
            intent.putExtra("data", bundle);
            startActivity(intent);
        } else {
            CourseInfoAndContentFragment fragment = new CourseInfoAndContentFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("my object", variables);
            fragment.setArguments(bundle);

            InfoFragment infoFragmentLocal = new InfoFragment();
            InfoContentTabsAdapter.infoFragment = infoFragmentLocal;
            ContentFragment contentFragmentLocal = new ContentFragment();
            InfoContentTabsAdapter.contentFragment = contentFragmentLocal;


            InfoContentTabsAdapter.infoFragment.setArguments(bundle);
            InfoContentTabsAdapter.contentFragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().replace(R.id.fdetail, fragment, "data").commit();
        }
    }
}
