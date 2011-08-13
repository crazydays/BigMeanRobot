package org.crazydays.robot;


import org.crazydays.robot.BigMeanRobotActivity;

import android.test.ActivityInstrumentationTestCase2;

/**
 * BigMeanRobotActivityTest
 */
public class BigMeanRobotActivityTest
    extends ActivityInstrumentationTestCase2<BigMeanRobotActivity>
{
    protected BigMeanRobotActivity activity;

    public BigMeanRobotActivityTest()
    {
        super(BigMeanRobotActivity.class.getPackage().getName(),
            BigMeanRobotActivity.class);
    }

    public void setUp()
    {
        SplashActivity.splashed = true; // prevent splash screen
        activity = getActivity();
    }
}
