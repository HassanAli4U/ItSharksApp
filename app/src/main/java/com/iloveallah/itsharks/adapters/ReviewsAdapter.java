package com.iloveallah.itsharks.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.iloveallah.itsharks.R;
import com.iloveallah.itsharks.ui.ReviewContent;

import java.util.List;

public class ReviewsAdapter extends ArrayAdapter<ReviewContent> {
    public ReviewsAdapter(Context context, int resource, List<ReviewContent> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.show_review_row, parent, false);
        }

        TextView userName = (TextView) convertView.findViewById(R.id.name);
        TextView courseName = (TextView) convertView.findViewById(R.id.course);
        TextView review = (TextView) convertView.findViewById(R.id.review);
        ReviewContent content = getItem(position);

        userName.setText(content.getUserName());
        courseName.setText(content.getCourseName());
        review.setText(content.getReview());


        return convertView;
    }
}
