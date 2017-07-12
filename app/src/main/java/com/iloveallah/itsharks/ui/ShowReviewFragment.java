package com.iloveallah.itsharks.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.iloveallah.itsharks.NetworkConnection;
import com.iloveallah.itsharks.R;
import com.iloveallah.itsharks.adapters.ReviewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShowReviewFragment extends Fragment {
    private ListView listView;
    private View view;
    private DatabaseReference mReviewDatabaseReference;
    private final List<ReviewContent> listReviews = new ArrayList<>();
    private ReviewsAdapter reviewsAdapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.show_review_fragment, null);
        listView = (ListView) view.findViewById(R.id.reviews_list);


        NetworkConnection connection = new NetworkConnection();
        if (!connection.isOnline()) {
            mReviewDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Reviews");
            reviewsAdapter = new ReviewsAdapter(getActivity(), R.layout.show_review_row, listReviews);
            listView.setAdapter(reviewsAdapter);
            mReviewDatabaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    ReviewContent reviewContent = dataSnapshot.getValue(ReviewContent.class);
                    listReviews.add(reviewContent);
                    reviewsAdapter.notifyDataSetChanged();

                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });
        } else {
            Toast.makeText(getActivity(), R.string.toast_newtwork_connection, Toast.LENGTH_SHORT).show();
        }
        return view;
    }

}
