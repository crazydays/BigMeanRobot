package org.crazydays.robot;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import static org.crazydays.robot.BigMeanRobotConstants.*;

/**
 * SplashActivity
 */
public class SplashActivity
    extends Activity
{
    /** splashed */
    protected static boolean splashed = false;

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
