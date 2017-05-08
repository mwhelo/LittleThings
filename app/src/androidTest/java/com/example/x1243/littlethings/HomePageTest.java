package com.example.x1243.littlethings;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by x1243 on 4/28/2017.
 */
public class HomePageTest {

    public ActivityTestRule<HomePage> mActivityRule = new ActivityTestRule<HomePage>(
            HomePage.class);

    private HomePage mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(FitnessPage.class.getName(),null,false);

    @Before
    public void setUp() throws Exception{

        mActivity = mActivityRule.getActivity();

    }

    @Test
    public void testActivityLaunch(){

        assertNotNull(mActivity.findViewById(R.id.button4));

        onView(withId(R.id.button4)).perform(click());

        Activity FitnessPage = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(FitnessPage);

        FitnessPage.finish();


    }

    @After
    public void tearDown() throws Exception{
        mActivity = null;
    }

}