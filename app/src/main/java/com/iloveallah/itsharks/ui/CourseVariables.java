package com.iloveallah.itsharks.ui;

import java.io.Serializable;

/**
 * Created by I Love Allah on 05/30/2017.
 */

public class CourseVariables implements Serializable {
    final String name;
    final String content;
    final int imageID;
    final int hours;
    final int weeks;
    final int daysPerWeek;

    public CourseVariables(String name, String content, int imageID, int hours, int weeks, int daysPerWeek) {
        this.name = name;
        this.content = content;
        this.imageID = imageID;
        this.hours = hours;
        this.weeks = weeks;
        this.daysPerWeek = daysPerWeek;
    }
}
