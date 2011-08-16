package org.crazydays.robot;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ViewFlipper;

/**
 * BigMeanRobotActivity
 */
public class BigMeanRobotActivity
    extends Activity
{
    /** flipper */
    protected ViewFlipper flipper;

    /**
     * @param state State
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle state)
    {
        super.onCreate(state);
        setContentView(R.layout.main);
        SplashActivity.splashIfNecessary(this);
        setupFlipper();
    }

    /**
     * Setup flipper.
     */
    private void setupFlipper()
    {
        flipper = (ViewFlipper) findViewById(R.id.robotFlipper);
    }

    /**
     * Start flipping.
     * 
     * @see android.app.Activity#onResume()
     */
    @Override
    protected void onResume()
    {
        super.onResume();
        flipper.startFlipping();
    }

    /**
     * Pause flipping.
     * 
     * @see android.app.Activity#onPause()
     */
    @Override
    protected void onPause()
    {
        flipper.stopFlipping();
        super.onPause();
    }

    /**
     * @param requestCode Request code
     * @param resultCode Result code
     * @param data Intent
     * @see android.app.Activity#onActivityResult(int,int,Intent)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case SplashActivity.RESULT_SPLASH:
                break;
        }
    }
}
