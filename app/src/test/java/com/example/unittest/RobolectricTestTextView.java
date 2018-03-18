package com.example.unittest;

import android.app.Activity;
import android.widget.TextView;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(CustomRobolectricRunner.class)
public class RobolectricTestTextView {

    Activity activity;

    @Before
    public void init() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void failTest() {
        TextView results = (TextView) activity.findViewById(R.id.hello);
        String resultsText = results.getText().toString();
        assertThat(resultsText, equalTo("Testing Android Rocks!"));
    }

    @Test
    public void passTest() {
        TextView results = (TextView) activity.findViewById(R.id.hello);
        String resultsText = results.getText().toString();
        assertThat(resultsText, equalTo("Hello World!"));
    }
}
