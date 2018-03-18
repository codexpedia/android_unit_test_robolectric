package com.example.unittest;

import android.app.Activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(CustomRobolectricRunner.class)
public class RobolectricTestMainActivity {
    @Test
    public void titleIsCorrect() throws Exception {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        assertThat("Should be Unit Test", activity.getTitle().toString(), equalTo("Fail this test on purpose"));
    }
}
