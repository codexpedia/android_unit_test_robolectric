package com.example.unittest;
import android.app.Application;
import android.content.Intent;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Shadows.shadowOf;

@RunWith(CustomRobolectricRunner.class)
@Config(constants = BuildConfig.class)
public class RobolectricTestAlarmManagerReceiver {

    @Test
    public void startServiceForTheScheduledAlarm(){
        Application application = RuntimeEnvironment.application;
        Intent expectedService = new Intent(application, SampleIntentService.class);

        AlarmManagerReceiver alarmManagerReceiver = new AlarmManagerReceiver();
        alarmManagerReceiver.onReceive(application, new Intent());

        Intent serviceIntent = shadowOf(application).getNextStartedService();
        assertNotNull(serviceIntent);
        assertEquals(serviceIntent.getComponent(),
                expectedService.getComponent());
    }
}