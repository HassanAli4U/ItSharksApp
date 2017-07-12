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
public class InstructorsAdapter extends BaseAdapter {
    private final ArrayList<String> instructor_name;
    private final ArrayList<Integer> instructor_image;
    private final ArrayList<String> course_name;
    private final Activity activity;

    public InstructorsAdapter(ArrayList<String> instructor_name, ArrayList<Integer> instructor_image, ArrayList<String> course_name, Activity activity) {
        this.instructor_name = instructor_name;
        this.instructor_image = instructor_image;
        this.course_name = course_name;
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
        View view1 = inflater.inflate(R.layout.instructors_row, null);
        ImageView image = (ImageView) view1.findViewById(R.id.instructor_imaage);
        TextView inst_name = (TextView) view1.findViewById(R.id.instructor_name);
        TextView cou_name = (TextView) view1.findViewById(R.id.course_name);
        // image.setImageResource(instructor_image.get(position));
        Picasso.with(activity).load(instructor_image.get(position)).into(image);

        inst_name.setText(instructor_name.get(position));
        cou_name.setText(course_name.get(position));
        return view1;
    }
}
