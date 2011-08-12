/* $Id$ */
package org.crazydays.robot;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowActivity.IntentForResult;
import static com.xtremelabs.robolectric.Robolectric.shadowOf;

import static org.crazydays.robot.BigMeanRobotConstants.*;

/**
 * BigMeanRobotActivityTest
 */
@RunWith(RobolectricTestRunner.class)
public class BigMeanRobotActivityTest
{
    /** activity */
    protected BigMeanRobotActivity activity;

    @Before
    public void setup()
    {
        activity = new BigMeanRobotActivity();
    }

    @Test
    public void testOnCreate()
    {
        SplashActivity.splashed = false;

        activity.onCreate(null);

        IntentForResult intentForResult =
            shadowOf(activity).getNextStartedActivityForResult();
        assertNotNull("intentForResult", intentForResult);
        assertEquals("requestCode", BigMeanRobotConstants.REQUEST_SPLASH,
            intentForResult.requestCode);
        assertEquals("intentClass", SplashActivity.class,
            shadowOf(intentForResult.intent).getIntentClass());
    }

    @Test
    public void testOnActivityResult_splash()
    {
        activity.onActivityResult(REQUEST_SPLASH, RESULT_SPLASH, null);
    }
}
