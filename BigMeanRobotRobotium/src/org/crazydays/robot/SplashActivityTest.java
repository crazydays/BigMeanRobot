package org.crazydays.robot;


import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

/**
 * SplashActivityTest
 */
public class SplashActivityTest
    extends ActivityInstrumentationTestCase2<SplashActivity>
{
    protected Solo solo;

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

    public void testIsDoneInThreeSeconds()
        throws InterruptedException
    {
        assertEquals("finishing", false, activity.isFinishing());
        Thread.sleep(3000);
        assertEquals("finishing", true, activity.isFinishing());
    }
}
