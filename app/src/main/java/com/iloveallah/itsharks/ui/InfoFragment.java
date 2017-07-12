package com.iloveallah.itsharks.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iloveallah.itsharks.R;

public class InfoFragment extends Fragment {
    private TextView name;
    private TextView hour;
    private TextView weeks;
    private TextView sessionsPerWeek;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.course_info_fragment, null);
        name = (TextView) view.findViewById(R.id.course_name);
        hour = (TextView) view.findViewById(R.id.course_hours);
        weeks = (TextView) view.findViewById(R.id.course_weeks);
        sessionsPerWeek = (TextView) view.findViewById(R.id.sessions);
        final CourseVariables variables = (CourseVariables) getArguments().getSerializable("my object");


        name.setText(variables.name);
        hour.setText("" + variables.hours);
        weeks.setText("" + variables.weeks);
        sessionsPerWeek.setText("" + variables.daysPerWeek + "");
        return view;
    }
}
