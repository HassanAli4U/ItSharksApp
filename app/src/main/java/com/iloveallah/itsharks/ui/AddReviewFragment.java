package com.iloveallah.itsharks.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.iloveallah.itsharks.NetworkConnection;
import com.iloveallah.itsharks.R;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;


public class AddReviewFragment extends Fragment {
   private EditText yourName, course_name, yourReview;
    private FloatingActionButton add;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mReviewDatabaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_review_fragment, null);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mReviewDatabaseReference = mFirebaseDatabase.getReference().child("Reviews").push();


        yourName = (EditText) view.findViewById(R.id.your_name);
        course_name = (EditText) view.findViewById(R.id.course_name);
        yourReview = (EditText) view.findViewById(R.id.your_review);
        add = (FloatingActionButton) view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name = yourName.getText().toString();
                final String course = course_name.getText().toString();
                final String review = yourReview.getText().toString();

                if (name.equals("") || name.equals("Your name")) {
                    yourName.setError("Enter your name");
                }
                if (course.equals("") || course.equals("Course name")) {
                    course_name.setError("Enter course name");
                }
                if (review.equals("") || review.equals("Your review")) {
                    yourReview.setError("Enter your review");
                }
                else {
                    NetworkConnection connection = new NetworkConnection();

                    if (!connection.isOnline()) {
                        ReviewContent reviewContent = new ReviewContent(name, course, review);

                        mReviewDatabaseReference.setValue(reviewContent);
                        Toast.makeText(getActivity(), R.string.addedReview, Toast.LENGTH_SHORT).show();
                        yourName.setText("");
                        yourReview.setText("");
                        course_name.setText("");
                    } else {
                        Toast.makeText(getActivity(), R.string.toast_newtwork_connection, Toast.LENGTH_SHORT).show();


                    }
                }
            }
        });

        return view;
    }
}
