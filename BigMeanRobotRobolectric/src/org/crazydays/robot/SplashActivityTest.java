package org.crazydays.robot;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowHandler;

/**
 * SplashActivityTest
 */
@RunWith(RobolectricTestRunner.class)
public class SplashActivityTest
{
    /** activity */
    protected SplashActivity activity;

    @Before
    public void setup()
    {
        activity = new SplashActivity();
    }

    @Test
    public void testOnCreate()
    {
        activity.onCreate(null);
        assertEquals("splashed", true, SplashActivity.splashed);
        assertEquals("finished", false, activity.isFinishing());
        ShadowHandler.runMainLooperToNextTask();
        assertEquals("finished", true, activity.isFinishing());
    }
}
