package org.crazydays.robot;


import com.jayway.android.robotium.solo.Solo;

import org.crazydays.robot.BigMeanRobotActivity;

import android.test.ActivityInstrumentationTestCase2;

/**
 * BigMeanRobotActivityTest
 */
public class BigMeanRobotActivityTest
    extends ActivityInstrumentationTestCase2<BigMeanRobotActivity>
{
    private Solo solo;

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
        solo = new Solo(getInstrumentation(), activity);
    }

    public void testOnPause()
    {
        getInstrumentation().callActivityOnPause(activity);
        assertEquals("flipper.flipping", false, activity.flipper.isFlipping());
    }

    public void testOnResume()
        throws InterruptedException
    {
        getInstrumentation().callActivityOnResume(activity);
        assertEquals("flipper.flipping", true, activity.flipper.isFlipping());
    }

    @Override
    public void tearDown()
        throws Exception
    {
        try {
            solo.finalize();
        } catch (Throwable e) {
            fail(e.getMessage());
        }
        getActivity().finish();
        super.tearDown();
    }
}
