package com.ketti.fancy.tab1;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Tab1 extends TabActivity
{
    
    private TabHost tabs;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabs = getTabHost();

        // LayoutInflater.from(this).inflate(R.layout.main,
        // tabs.getTabContentView(), true);

        // create 1st tab spec
        TabHost.TabSpec spec = tabs.newTabSpec("tab1");
        spec.setContent(new Intent(this, FirstTabActivity.class));
        // spec.setContent(R.id.tab1Clock);
        spec.setIndicator("Clock");
        tabs.addTab(spec);

        // create 2nd tab spec
        spec = tabs.newTabSpec("tab2");
        spec.setContent(new Intent(this, SecondTabActivity.class));
        // spec.setContent(R.id.tab2Button);
        spec.setIndicator("Button");
        tabs.addTab(spec);

        // initialize tab focus
        initTabFocus();
    }

    private void initTabFocus() {
        Intent reqIntent = getIntent();
        Bundle extras = reqIntent.getExtras();
        if ( extras == null ) {
            return;
        }

        int reqTabId = extras.getInt("REQ_TAB_ID", -1);
        switch ( reqTabId ) {
            case 110:
                tabs.setCurrentTabByTag("tab1");
            break;

            case 120:
                tabs.setCurrentTabByTag("tab2");
            break;
        }

    }
}
