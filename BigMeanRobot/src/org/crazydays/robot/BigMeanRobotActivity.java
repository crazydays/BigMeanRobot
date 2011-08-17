package org.crazydays.robot;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ViewFlipper;

/**
 * BigMeanRobotActivity
 */
public class BigMeanRobotActivity
    extends Activity
{
    /** self */
    final protected BigMeanRobotActivity self = this;

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
        flipper.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                self.insult();
            }
        });
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

    /**
     * Insult the user.
     */
    protected void insult()
    {
        startYapping();
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                self.stopYapping();
            }
        }, 3500);
    }

    /**
     * Start yapping.
     */
    private void startYapping()
    {
        flipper.setFocusable(false);
        flipper.startFlipping();
    }

    /**
     * Stop yapping.
     */
    private void stopYapping()
    {
        flipper.stopFlipping();
        flipper.setFocusable(true);
    }
}
