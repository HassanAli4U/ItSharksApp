package com.iloveallah.itsharks.contentProvider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by I Love Allah on 06/03/2017.
 */

public class ContentProvider extends android.content.ContentProvider {
    private final UriMatcher MATCHER = buildMatcher();
    private static final int review = 1;
    private Database db = new Database(getContext());

    private static UriMatcher buildMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(Contract.CONTENT_AUTHORITY, Database.TABLE_NAME, review);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        db = new Database(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Cursor cursor;
        switch (MATCHER.match(uri)) {
            case review: {
                cursor = db.getReadableDatabase().query(
                        Database.TABLE_NAME, strings, s, strings1,
                        null, null, s1);
                break;
            }
            default:
                throw new UnsupportedOperationException("error");
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase sql_db = db.getWritableDatabase();
        Uri newUri;
        switch (MATCHER.match(uri)) {
            case review: {
                long id = sql_db.insert(Database.TABLE_NAME, null, contentValues);
                if (id > 0) {
                    newUri = Contract.CoursesEntry.CourseUri(id);
                } else {
                    throw new android.database.SQLException("insert Failed ");
                }
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri");
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return newUri;

    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {

        int Deletedcourse;
        int match = MATCHER.match(uri);
        SQLiteDatabase s_db = db.getWritableDatabase();
        if (s == null) {
            s = "1";
        }
        switch (match) {
            case review:
                Deletedcourse = s_db.delete(Database.TABLE_NAME, s, strings);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if (Deletedcourse != 0) {
            if (getContext() != null && getContext().getContentResolver() != null) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
        }
        s_db.close();
        return Deletedcourse;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    private void deleteDatabase() {
        db.close();
        Context context = getContext();
        Database.deleteDatabase(context);
        db = new Database(getContext());
    }

    private void notifyChange(Uri uri) {
        getContext().getContentResolver().notifyChange(uri, null);
    }
}
