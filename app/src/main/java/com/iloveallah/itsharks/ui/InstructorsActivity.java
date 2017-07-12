package com.iloveallah.itsharks.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.iloveallah.itsharks.R;
import com.iloveallah.itsharks.adapters.InstructorsAdapter;
import com.iloveallah.itsharks.contentProvider.Contract;
import com.iloveallah.itsharks.contentProvider.Database;

import java.util.ArrayList;

public class InstructorsActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> instructorName;
    private ArrayList<String> courseName;
    private ArrayList<Integer> intsructorImage;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructors);
        activity = this;
        listView = (ListView) findViewById(R.id.instructor_list);


        new AsyncTask<Void, Void, Cursor>() {
            @Override
            protected Cursor doInBackground(Void... voids) {
                Log.d("asd", "in");

                Cursor cursor = getContentResolver().query(
                        Contract.CoursesEntry.CONTENT_URI,
                        null,
                        null,
                        null,
                        null
                );
                return cursor;
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
                if (cursor.moveToFirst()) {
                    instructorName = new ArrayList<>();
                    courseName = new ArrayList<>();
                    intsructorImage = new ArrayList<>();
                    do {
                        String inst_name = cursor.getString(cursor.getColumnIndex(Database.INSTRUCTOR_NAME));
                        instructorName.add(inst_name);
                        String cours_name = cursor.getString(cursor.getColumnIndex(Database.COURSE_NAME));
                        courseName.add(cours_name);
                        int inst_image = cursor.getInt(cursor.getColumnIndex(Database.INSTRUCTOR_IMAGE));
                        intsructorImage.add(inst_image);

                    } while (cursor.moveToNext());
                }
                InstructorsAdapter adapter = new InstructorsAdapter(instructorName, intsructorImage, courseName, activity);
                listView.setAdapter(adapter);
            }
        }.execute();


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
                Intent i = new Intent(getApplicationContext(), InstructorsActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.instruct: {

                getCallingActivity();
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
                Toast.makeText(InstructorsActivity.this, R.string.error, Toast.LENGTH_SHORT).show();
                return true;
            }
        }
    }
}
