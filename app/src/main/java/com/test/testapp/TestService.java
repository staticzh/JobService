package com.test.testapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zh on 2018/10/16.
 */

public class TestService extends Service{

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("service","TestService--onCreate");

        Intent ret = new Intent(TestService.this, GuardJobService.class);
        startService(ret);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service","TestService-- onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
