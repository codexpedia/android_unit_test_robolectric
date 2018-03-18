package com.example.unittest;


import android.app.Activity;
import android.content.Intent;
import android.widget.Button;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(CustomRobolectricRunner.class)
public class RobolectricTestButton {
    Activity activity;

    @Before
    public void init() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {
        Button button = (Button) activity.findViewById(R.id.button);
        button.performClick();
        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        assertEquals(SecondActivity.class.getCanonicalName(), intent.getComponent().getClassName());
    }

    @Test
    public void testButtonClick() throws Exception {
        Button view = (Button) activity.findViewById(R.id.button);
        assertNotNull(view);
        view.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Hello"));
    }
}
