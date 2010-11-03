package net.brainage.appa;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /**
     * @param v
     */
    public void onClickCallActivity(View v) {
        Intent i = new Intent();
        i.setComponent(new ComponentName("net.brainage.appb", "net.brainage.appb.Main"));
        startActivity(i);
    }

    /**
     * @param v
     */
    public void onClickCallFirstTab(View v) {
        Intent i = new Intent();
        i.setComponent(new ComponentName("com.ketti.fancy.tab1", "com.ketti.fancy.tab1.Tab1"));
        i.putExtra("REQ_TAB_ID", 110);
        startActivity(i);
    }

    /**
     * @param v
     */
    public void onClickCallSecondTab(View v) {
        Intent i = new Intent();
        i.setComponent(new ComponentName("com.ketti.fancy.tab1", "com.ketti.fancy.tab1.Tab1"));
        i.putExtra("REQ_TAB_ID", 120);
        startActivity(i);

    }

    public void onClickCallMonthlyCalendar(View v) {
        Intent intent = new Intent();
        intent.setClassName("com.android.calendar", "com.android.calendar.LaunchActivity");
        intent.putExtra("DETAIL_VIEW_MODE", 0);
        startActivity(intent);
    }

    public void onClickCallDailyCalendar(View v) {
        Intent intent = new Intent();
        intent.setClassName("com.android.calendar", "com.android.calendar.LaunchActivity");
        intent.putExtra("DETAIL_VIEW_MODE", 2);
        startActivity(intent);
    }

}
