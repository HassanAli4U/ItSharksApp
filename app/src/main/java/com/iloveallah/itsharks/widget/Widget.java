package com.iloveallah.itsharks.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import com.iloveallah.itsharks.R;

/**
 * Implementation of App Widget functionality.
 */
public class Widget extends AppWidgetProvider {
    private static final String OnClickPhone1 = "OnClickPhone1";
    private static final String OnClickPhone2 = "OnClickPhone2";
    private static final String OnClickPhone3 = "OnClickPhone3";
    private static final String OnClickFacbook = "OnClickFacbook";
    private static final String OnClickGoogle = "OnClickGoogle";

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                 int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        views.setOnClickPendingIntent(R.id.phone,
                getPendingSelfIntent(context, OnClickPhone1));
        views.setOnClickPendingIntent(R.id.phone2,
                getPendingSelfIntent(context, OnClickPhone2));
        views.setOnClickPendingIntent(R.id.phone3,
                getPendingSelfIntent(context, OnClickPhone3));
        views.setOnClickPendingIntent(R.id.face,
                getPendingSelfIntent(context, OnClickFacbook));
        views.setOnClickPendingIntent(R.id.google,
                getPendingSelfIntent(context, OnClickGoogle));
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    private PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (OnClickPhone1.equals(intent.getAction())) {
            Intent intentAction = new Intent();
            intentAction.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri uri = Uri.parse("tel:" + "01017743315".trim());
            intentAction.setAction(Intent.ACTION_CALL);
            intentAction.setData(uri);
            context.startActivity(intentAction);
        } else if (OnClickPhone2.equals(intent.getAction())) {
            Intent intentAction = new Intent();
            intentAction.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri uri = Uri.parse("tel:" + "01140325255".trim());
            intentAction.setAction(Intent.ACTION_CALL);
            intentAction.setData(uri);
            context.startActivity(intentAction);
        } else if (OnClickPhone3.equals(intent.getAction())) {
            Intent intentAction = new Intent();
            intentAction.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Uri uri = Uri.parse("tel:" + "01200302842".trim());
            intentAction.setAction(Intent.ACTION_CALL);
            intentAction.setData(uri);
            context.startActivity(intentAction);
        } else if (OnClickFacbook.equals(intent.getAction())) {
            Intent intentAction = new Intent();
            intentAction.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            intentAction.setAction(Intent.ACTION_VIEW);
            Uri web = Uri.parse("https://www.facebook.com/ITSharks");
            intentAction.setData(web);
            context.startActivity(intentAction);
        } else if (OnClickGoogle.equals(intent.getAction())) {
            Intent intentAction = new Intent();
            intentAction.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            intentAction.setAction(Intent.ACTION_VIEW);
            Uri web = Uri.parse("https://plus.google.com/+ITSharksTrainingCenterCairo");
            intentAction.setData(web);
            context.startActivity(intentAction);
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

