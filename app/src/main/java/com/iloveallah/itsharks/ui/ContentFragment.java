package com.iloveallah.itsharks.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iloveallah.itsharks.R;

public class ContentFragment extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.course_content_fragment, null);
        textView = (TextView) view.findViewById(R.id.content_text);
        final CourseVariables variables = (CourseVariables) getArguments().getSerializable("my object");
        textView.setText(variables.content);
        return view;
    }
}
