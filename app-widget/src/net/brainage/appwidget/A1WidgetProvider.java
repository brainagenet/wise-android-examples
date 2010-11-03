/*
 * (#) net.brainage.appwidget.A1WidgetProvider
 * Created on 2010. 11. 3.
 */
package net.brainage.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * 
 * 
 * @author ntmyoungseok.seo@lge.com
 */
public class A1WidgetProvider extends AppWidgetProvider
{

    /**
     * 
     */
    private static final boolean DEBUG = AppWidgetApplication.DEBUG;

    /**
     * 
     */
    private static final String TAG = "A1WidgetProvider";

    /**
     * 
     */
    private static final String PACKAGE_NAME = "net.brainage.appwidget";

    /**
     * 
     */
    private static final ComponentName COMPONENT_NAME = new ComponentName(PACKAGE_NAME,
            PACKAGE_NAME + ".A1WidgetProvider");

    /**
     * 
     * @param context
     * @param appWidgetIds
     * @see android.appwidget.AppWidgetProvider#onDeleted(android.content.Context, int[])
     */
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        if ( DEBUG ) {
            Log.d(TAG, "onDeleted() ---------------------------");
        }
    }

    /**
     * 
     * @param context
     * @see android.appwidget.AppWidgetProvider#onDisabled(android.content.Context)
     */
    @Override
    public void onDisabled(Context context) {
        if ( DEBUG ) {
            Log.d(TAG, "onDisabled() ---------------------------");
        }

        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(COMPONENT_NAME,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

    /**
     * 
     * @param context
     * @see android.appwidget.AppWidgetProvider#onEnabled(android.content.Context)
     */
    @Override
    public void onEnabled(Context context) {
        if ( DEBUG ) {
            Log.d(TAG, "onEnabled() ---------------------------");
        }

        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(COMPONENT_NAME,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

    /**
     * 
     * @param context
     * @param intent
     * @see android.appwidget.AppWidgetProvider#onReceive(android.content.Context, android.content.Intent)
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        if ( DEBUG ) {
            Log.d(TAG, "onReceive() ---------------------------");
        }

        final String action = intent.getAction();
        if ( DEBUG ) {
            Log.d(TAG, "    action = " + action);
        }
        if ( AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(action) ) {
            Bundle extras = intent.getExtras();
            final int appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
            if ( appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID ) {
                this.onDeleted(context, new int[] { appWidgetId });
            }
        } else {
            super.onReceive(context, intent);
        }
    }

    /**
     * 
     * @param context
     * @param appWidgetManager
     * @param appWidgetIds
     * @see android.appwidget.AppWidgetProvider#onUpdate(android.content.Context, android.appwidget.AppWidgetManager, int[])
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        if ( DEBUG ) {
            Log.d(TAG, "onUpdate() ---------------------------");
        }

        final int N = appWidgetIds.length;
        for ( int i = 0 ; i < N ; i++ ) {
            int appWidgetId = appWidgetIds[i];
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    /**
     * @param context
     * @param appWidgetManager
     * @param appWidgetId
     */
    public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
            int appWidgetId) {
        if ( DEBUG ) {
            Log.d(TAG, "updateAppWidget(appWidgetId='" + appWidgetId
                    + "') ---------------------------");
        }

        RemoteViews views = new RemoteViews(PACKAGE_NAME, R.layout.a1_appwidget);

        Intent i = new Intent();
        i.setComponent(new ComponentName("com.ketti.fancy.tab1", "com.ketti.fancy.tab1.Tab1"));
        i.putExtra("REQ_TAB_ID", 110);
        PendingIntent pi = PendingIntent.getActivity(context, 1, i, 0);
        views.setOnClickPendingIntent(R.id.area01, pi);

        i = new Intent();
        i.setComponent(new ComponentName("com.ketti.fancy.tab1", "com.ketti.fancy.tab1.Tab1"));
        i.putExtra("REQ_TAB_ID", 120);
        pi = PendingIntent.getActivity(context, 2, i, 0);
        views.setOnClickPendingIntent(R.id.area02, pi);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}
