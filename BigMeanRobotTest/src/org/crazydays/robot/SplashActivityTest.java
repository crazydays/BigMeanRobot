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

    @Override
    public void setUp()
        throws Exception
    {
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

    public void testIsDoneInThreeSeconds()
        throws InterruptedException
    {
        assertEquals("finishing", false, activity.isFinishing());
        Thread.sleep(3000);
        assertEquals("finishing", true, activity.isFinishing());
    }
}
