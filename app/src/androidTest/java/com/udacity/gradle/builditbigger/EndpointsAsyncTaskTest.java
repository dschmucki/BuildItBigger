package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import junit.framework.Assert;

import java.util.concurrent.ExecutionException;

/**
 * Created by domi on 05.12.15.
 */
public class EndpointsAsyncTaskTest extends ApplicationTestCase<Application> {

    public EndpointsAsyncTaskTest() {
        super(Application.class);
    }

    public EndpointsAsyncTaskTest(Class<Application> applicationClass) {
        super(applicationClass);
    }

    public void testEndpointsAsyncTaskRetrievesNotNull() throws ExecutionException, InterruptedException {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        Assert.assertNotNull(endpointsAsyncTask.execute(getContext()).get());
    }
}
