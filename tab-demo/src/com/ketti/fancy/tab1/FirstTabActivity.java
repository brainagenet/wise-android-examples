/*
 * (#) com.ketti.fancy.tab1.FirstTabActivity
 * Created on 2010. 7. 20.
 */
package com.ketti.fancy.tab1;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * 
 * @author ms29.seo@gmail.com
 * @version 1.0
 */
public class FirstTabActivity extends Activity {

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_tab);
    }

}
