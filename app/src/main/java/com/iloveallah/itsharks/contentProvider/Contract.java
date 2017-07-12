package com.iloveallah.itsharks.contentProvider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;


/**
 * Created by I Love Allah on 06/03/2017.
 */

public class Contract {
    public static final String CONTENT_AUTHORITY = "com.iloveallah.itsharks";

    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    public static final class CoursesEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(Database.TABLE_NAME).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + Database.TABLE_NAME;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + Database.TABLE_NAME;


        public static Uri CourseUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
