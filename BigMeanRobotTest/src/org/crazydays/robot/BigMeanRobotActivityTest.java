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

    @Override
    public void setUp()
        throws Exception
    {
        SplashActivity.splashed = true; // prevent splash screen
        super.setUp();
        activity = getActivity();
    }

    @Override
    public void tearDown()
        throws Exception
    {
        activity.finish();
        super.tearDown();
    }
}
