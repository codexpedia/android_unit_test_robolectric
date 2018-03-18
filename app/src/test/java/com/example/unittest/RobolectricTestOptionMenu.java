package com.example.unittest;

import android.app.Activity;
import android.view.Menu;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(CustomRobolectricRunner.class)
public class RobolectricTestOptionMenu {
    Activity activity;

    @Before
    public void init() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void onCreate_shouldInflateLayout() throws Exception {
        final Menu menu = Shadows.shadowOf(activity).getOptionsMenu();
        assertThat(menu.findItem(R.id.item1).getTitle().toString(), equalTo("item 1"));
        assertThat(menu.findItem(R.id.item2).getTitle().toString(), equalTo("item 2"));
    }

    @Test
    public void clickMenuItem_shouldDelegateClickToFragment() {
        Shadows.shadowOf(activity).clickMenuItem(R.id.item4);
        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Clicked Item 4"));
    }
}
