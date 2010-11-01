/*
 * (#) net.brainage.appb.B1Activity
 * Created on 2010. 10. 20.
 */
package net.brainage.appb;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * 
 * @author ntmyoungseok.seo@lge.com
 */
public class B1Activity extends Activity
{

    /**
     * 
     * @param savedInstanceState
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.b1_activity);
    }

}
