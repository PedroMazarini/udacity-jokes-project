package br.com.jokes.builditbigger;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.EndpointAsynctask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertFalse;

/**
 * Created by Pedro Mazarini on 03/Nov/2018.
 **/
@RunWith(AndroidJUnit4.class)
public class LoadingJokesTest  {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");
        String result = null;
        EndpointAsynctask endpointsAsyncTask = new EndpointAsynctask();
        endpointsAsyncTask.execute(activityActivityTestRule.getActivity());
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
        assertFalse(result != "");
    }


}
