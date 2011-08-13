package org.crazydays.robot;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowActivity.IntentForResult;
import com.xtremelabs.robolectric.shadows.ShadowHandler;
import static com.xtremelabs.robolectric.Robolectric.shadowOf;

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
    public void testSplashIfNecessary()
    {
        SplashActivity.splashIfNecessary(activity);
        IntentForResult intentForResult =
            shadowOf(activity).peekNextStartedActivityForResult();
        assertEquals("requestCode", SplashActivity.REQUEST_SPLASH,
            intentForResult.requestCode);
        assertEquals("intent.activity", SplashActivity.class,
            shadowOf(intentForResult.intent).getIntentClass());
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
