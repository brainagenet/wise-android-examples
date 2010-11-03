/*
 * (#) net.brainage.appwidget.AppWidgetApplication
 * Created on 2010. 11. 3.
 */
package net.brainage.appwidget;

import android.app.Application;

/**
 * 
 * 
 * @author ntmyoungseok.seo@lge.com
 */
public class AppWidgetApplication extends Application
{
    
    /**
     * 
     */
    public static final boolean DEBUG = true;

    /**
     * 
     */
    private static AppWidgetApplication singleton;
    
    /**
     * Return the application singleton instance
     * 
     * @return
     */
    public static AppWidgetApplication getInstance() {
        return singleton;
    }

    /**
     * 
     * @see android.app.Application#onCreate()
     */
    @Override
    public final void onCreate() {
        super.onCreate();
        singleton = this;
    }
    
    
    
}
