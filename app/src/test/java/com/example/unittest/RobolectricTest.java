package com.example.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.RobolectricTestRunner;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class RobolectricTest {
    @Test
    public void passTest() {
        assertThat(RuntimeEnvironment.application, notNullValue());
    }

    @Test
    public void failTest() {
        assertThat(RuntimeEnvironment.application, nullValue());
    }
}