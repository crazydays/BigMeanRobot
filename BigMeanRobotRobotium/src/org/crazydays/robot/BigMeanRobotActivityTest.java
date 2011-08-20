package org.crazydays.robot;


import com.jayway.android.robotium.solo.Solo;

import org.crazydays.robot.BigMeanRobotActivity;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

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

    public void testFlipperClicked()
        throws InterruptedException
    {
        solo.clickOnView(activity.flipper);
        assertEquals("flipping", true, activity.flipper.isFlipping());
        assertEquals("clickable", false, activity.flipper.isClickable());
        Thread.sleep(BigMeanRobotActivity.TICK * 10);
        assertEquals("flipping", false, activity.flipper.isFlipping());
        assertEquals("visible", View.VISIBLE,
            activity.insultChat.getVisibility());
        assertFalse("insult", activity.insultChat.getText().equals(""));
        Thread.sleep(BigMeanRobotActivity.TICK * 5);
        assertEquals("visible", View.INVISIBLE,
            activity.insultChat.getVisibility());
        assertEquals("clickable", true, activity.flipper.isClickable());
    }
}
