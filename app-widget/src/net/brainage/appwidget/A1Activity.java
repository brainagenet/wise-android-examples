/*
 * (#) net.brainage.appwidget.A1Activity
 * Created on 2010. 11. 3.
 */
package net.brainage.appwidget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 
 * 
 * @author ntmyoungseok.seo@lge.com
 */
public class A1Activity extends Activity
{

    /**
     * 
     */
    // private static final boolean DEBUG = AppWidgetApplication.DEBUG;

    /**
     * 
     */
    private boolean customTitleSupported;

    /**
     * 
     * @param savedInstanceState
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check if custom title is supported BEFORE setting the content view!
        customTitleSupported = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

        // set contentview
        setContentView(R.layout.a1_appwidget);

        TextView area01 = (TextView) findViewById(R.id.area01);
        area01.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setComponent(new ComponentName("com.ketti.fancy.tab1",
                        "com.ketti.fancy.tab1.Tab1"));
                i.putExtra("REQ_TAB_ID", 110);
                startActivity(i);
            }
        });

        TextView area02 = (TextView) findViewById(R.id.area02);
        area02.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setComponent(new ComponentName("com.ketti.fancy.tab1",
                        "com.ketti.fancy.tab1.Tab1"));
                i.putExtra("REQ_TAB_ID", 120);
                startActivity(i);
            }
        });

        // set custom titlebar
        customTitleBar(getText(R.string.app_name).toString(), getText(R.string.title_main_menu)
                .toString());
    }

    public void customTitleBar(String left, String right) {
        if ( right.length() > 20 )
            right = right.substring(0, 20);
        // set up custom title
        if ( customTitleSupported ) {
            getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_titlebar);
            TextView titleTvLeft = (TextView) findViewById(R.id.titleTvLeft);
            TextView titleTvRight = (TextView) findViewById(R.id.titleTvRight);

            titleTvLeft.setText(left);
            titleTvRight.setText(right);

            ProgressBar titleProgressBar;
            titleProgressBar = (ProgressBar) findViewById(R.id.leadProgressBar);

            // hide the progress bar if it is not needed
            titleProgressBar.setVisibility(ProgressBar.GONE);
        }
    }

}
