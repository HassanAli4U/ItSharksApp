package com.iloveallah.itsharks.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.iloveallah.itsharks.R;
import com.iloveallah.itsharks.adapters.CoursesAdapter;
import com.iloveallah.itsharks.contentProvider.Contract;
import com.iloveallah.itsharks.contentProvider.Database;

import java.util.ArrayList;

/**
 * Created by I Love Allah on 05/30/2017.
 */

public class CoursesFragment extends Fragment {
    private ListView coursesList;
    private ArrayList<String> arrCourseName;
    private ArrayList<String> arrContent;
    private ArrayList<Integer> arrCourseImage;
    private ArrayList<Integer> arrHours;
    private ArrayList<Integer> arrWeeks;
    private ArrayList<Integer> arrPerWeeks;
    private Listener listener;

    void setListener(Listener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.courses_fragment, container, false);
        coursesList = (ListView) view.findViewById(R.id.course_list);

        new AsyncTask<Void, Void, Cursor>() {
            @Override
            protected Cursor doInBackground(Void... voids) {
                Log.d("asd", "in");

                Cursor cursor = getContext().getContentResolver().query(
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
                    arrCourseName = new ArrayList<>();
                    arrContent = new ArrayList<>();
                    arrCourseImage = new ArrayList<>();
                    arrHours = new ArrayList<>();
                    arrWeeks = new ArrayList<>();
                    arrPerWeeks = new ArrayList<>();
                    do {
                        String name = cursor.getString(cursor.getColumnIndex(Database.COURSE_NAME));

                        arrCourseName.add(name);
                        String cont = cursor.getString(cursor.getColumnIndex(Database.COURSE_CONTENT));

                        arrContent.add(cont);
                        int image = cursor.getInt(cursor.getColumnIndex(Database.COURSE_IMAGE));
                        arrCourseImage.add(image);
                        int hr = cursor.getInt(cursor.getColumnIndex(Database.COURSE_HOURS));
                        arrHours.add(hr);
                        int wee = cursor.getInt(cursor.getColumnIndex(Database.COURSE_WEEKS));
                        arrWeeks.add(wee);
                        int pw = cursor.getInt(cursor.getColumnIndex(Database.COURSE_SESSIONS));
                        arrPerWeeks.add(pw);
                    } while (cursor.moveToNext());
                }
                final CoursesAdapter adapter = new CoursesAdapter(arrCourseName, arrCourseImage, getActivity());
                coursesList.setAdapter(adapter);
            }
        }.execute();
//        final CoursesAdapter adapter=new CoursesAdapter(arrCourseName,arrCourseImage,getActivity());
//        coursesList.setAdapter(adapter);


        coursesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), CourseInfoAndContentActivity.class);
                intent.putExtra("item", i);
                intent.putExtra("name", arrCourseName);
                intent.putExtra("hour", arrHours);
                intent.putExtra("week", arrWeeks);
                intent.putExtra("per", arrPerWeeks);
                intent.putExtra("arrContent", arrContent);
                intent.putExtra("image", arrCourseImage.get(i));
                CourseVariables variables = new CourseVariables(arrCourseName.get(i), arrContent.get(i), arrCourseImage.get(i), arrHours.get(i), arrWeeks.get(i), arrPerWeeks.get(i));
                listener.response(variables);
            }
        });
        return view;
    }
}
