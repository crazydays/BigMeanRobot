package org.crazydays.robot;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static org.crazydays.robot.BigMeanRobotConstants.*;

/**
 * BigMeanRobotActivity
 */
public class BigMeanRobotActivity
    extends Activity
{
    /**
     * @param state State
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle state)
    {
        super.onCreate(state);
        setContentView(R.layout.main);
        splash();
    }

    /**
     * Show splash if it hasn't been already.
     */
    private void splash()
    {
        if (!SplashActivity.hasSplashed()) {
            Intent intent = new Intent(this, SplashActivity.class);
            startActivityForResult(intent, REQUEST_SPLASH);
        }
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
            case RESULT_SPLASH:
                break;
        }
    }
}