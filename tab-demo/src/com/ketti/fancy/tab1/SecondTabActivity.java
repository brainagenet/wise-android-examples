/*
 * (#) com.ketti.fancy.tab1.SecondTabActivity
 * Created on 2010. 7. 20.
 */
package com.ketti.fancy.tab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * 
 * 
 * @author ms29.seo@gmail.com
 * @version 1.0
 */
public class SecondTabActivity extends Activity {

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_tab);
    }

    /**
     * clickMeButton의 onClick Event를 처리한다.
     * 
     * @param v 이벤트가 발생한 clickMeButton의 Instance
     */
    public void clickMeButtonOnClick(View v) {
        Toast.makeText(this,
                "This is second Tab!!",
                Toast.LENGTH_SHORT).show();
    }

}
