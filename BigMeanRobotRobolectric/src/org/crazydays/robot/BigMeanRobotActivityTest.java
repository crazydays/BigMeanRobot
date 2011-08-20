/* $Id$ */
package org.crazydays.robot;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import android.view.View;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowHandler;
import com.xtremelabs.robolectric.shadows.ShadowActivity.IntentForResult;
import static com.xtremelabs.robolectric.Robolectric.shadowOf;

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
        assertSame("self", activity, activity.self);
    }

    @Test
    public void testOnCreate()
    {
        SplashActivity.splashed = false;

        activity.onCreate(null);

        IntentForResult intentForResult =
            shadowOf(activity).getNextStartedActivityForResult();
        assertNotNull("intentForResult", intentForResult);
        assertEquals("requestCode", SplashActivity.REQUEST_SPLASH,
            intentForResult.requestCode);
        assertEquals("intentClass", SplashActivity.class,
            shadowOf(intentForResult.intent).getIntentClass());
        assertNotNull("insultChat", activity.insultChat);
        assertNotNull("flipper", activity.flipper);
        assertNotNull("insultomatic", activity.insultomatic);
    }

    @Test
    public void testOnActivityResult_splash()
    {
        activity.onActivityResult(SplashActivity.REQUEST_SPLASH,
            SplashActivity.RESULT_SPLASH, null);
    }

    @Test
    public void testInsult()
    {
        activity.onCreate(null);
        activity.flipper.performClick();
        assertEquals("flipping", true, activity.flipper.isFlipping());
        assertEquals("clickable", false, activity.flipper.isClickable());
        ShadowHandler.runMainLooperToNextTask();
        assertEquals("flipping", false, activity.flipper.isFlipping());
        assertEquals("visible", View.VISIBLE,
            activity.insultChat.getVisibility());
        assertFalse("insult", activity.insultChat.getText().equals(""));
        ShadowHandler.runMainLooperToNextTask();
        assertEquals("visible", View.INVISIBLE,
            activity.insultChat.getVisibility());
        assertEquals("clickable", true, activity.flipper.isClickable());
    }
}
