package com.iloveallah.itsharks.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iloveallah.itsharks.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by I Love Allah on 9/21/2016.
 */
public class CoursesAdapter extends BaseAdapter {
    private final ArrayList<String> course_name;
    private final ArrayList<Integer> course_image;
    private final Activity activity;

    public CoursesAdapter(ArrayList<String> course_name, ArrayList<Integer> course_image, Activity activity) {
        this.course_name = course_name;
        this.course_image = course_image;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return course_name.size();
    }

    @Override
    public Object getItem(int i) {
        return course_name.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view1 = inflater.inflate(R.layout.courses_row, null);
        ImageView image = (ImageView) view1.findViewById(R.id.course_imaage);
        TextView name = (TextView) view1.findViewById(R.id.course_name);
        // image.setImageResource(course_image.get(position));
        Picasso.with(activity).load(course_image.get(position)).into(image);
        name.setText(course_name.get(position));
        return view1;
    }
}
