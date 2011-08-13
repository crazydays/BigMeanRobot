package org.crazydays.robot;


import android.test.ActivityInstrumentationTestCase2;

/**
 * SplashActivityTest
 */
public class SplashActivityTest
    extends ActivityInstrumentationTestCase2<SplashActivity>
{
    protected SplashActivity activity;

    public SplashActivityTest()
    {
        super(SplashActivity.class.getPackage().getName(), SplashActivity.class);
    }

    public void setUp()
    {
        activity = getActivity();
    }

    public void testIsDoneInThreeSeconds()
        throws InterruptedException
    {
        assertEquals("finishing", false, activity.isFinishing());
        Thread.sleep(3000);
        assertEquals("finishing", true, activity.isFinishing());
    }
}
