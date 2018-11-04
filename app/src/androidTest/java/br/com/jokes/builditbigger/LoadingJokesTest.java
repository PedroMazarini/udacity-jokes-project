package br.com.jokes.builditbigger;


import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.EndpointAsynctask;

import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.InstrumentationRegistry.getContext;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by Pedro Mazarini on 03/Nov/2018.
 **/
@RunWith(AndroidJUnit4.class)
public class LoadingJokesTest  {


    @SuppressWarnings("unchecked")
    @Test
    public void test() {

        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");
        String result = null;
        EndpointAsynctask endpointsAsyncTask = new EndpointAsynctask();
        endpointsAsyncTask.execute(getContext());
        try {
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }


}
