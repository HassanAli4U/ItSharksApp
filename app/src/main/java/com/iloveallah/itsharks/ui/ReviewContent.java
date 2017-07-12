package com.iloveallah.itsharks.ui;

/**
 * Created by I Love Allah on 05/26/2017.
 */

public class ReviewContent {


    private String userName;
    private String courseName;
    private String review;

    public ReviewContent() {
    }

    public ReviewContent(String userName, String courseName, String review) {
        this.userName = userName;
        this.courseName = courseName;
        this.review = review;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
