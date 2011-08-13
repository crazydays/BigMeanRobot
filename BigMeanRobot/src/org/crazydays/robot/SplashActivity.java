package org.crazydays.robot;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * SplashActivity
 */
public class SplashActivity
    extends Activity
{
    /** request: splash */
    public final static int REQUEST_SPLASH = 13;

    /** result: splash */
    public final static int RESULT_SPLASH = 11;

    /** splashed */
    protected static boolean splashed = false;

    /**
     * Show splash if it hasn't been already.
     */
    public static void splashIfNecessary(Activity activity)
    {
        if (!hasSplashed()) {
            Intent intent = new Intent(activity, SplashActivity.class);
            activity.startActivityForResult(intent, REQUEST_SPLASH);
        }
    }

    /**
     * Has splash screen happened.
     * 
     * @return Splashed
     */
    public static boolean hasSplashed()
    {
        return splashed;
    }

    /** handler */
    protected Handler handler = new Handler();

    /**
     * @param state State
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle state)
    {
        splashed = true;

        super.onCreate(state);
        setContentView(R.layout.splash);
        closeInSeconds();
    }

    /**
     * Close in seconds.
     */
    private void closeInSeconds()
    {
        final Activity that = this;
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                that.setResult(RESULT_SPLASH);
                that.finish();
            }
        }, 2500);
    }
}
