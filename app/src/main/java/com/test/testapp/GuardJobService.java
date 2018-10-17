package com.test.testapp;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by zh on 2018/10/16.
 */

public class GuardJobService extends JobService {
    @Override
    public void onCreate() {
        super.onCreate();
        getJobInfo();
        Log.e("service","GuardJobService--onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service","GuardJobService--onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e("service","GuardJobService--onStartJob");
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e("service","GuardJobService--onStopJob");
        return false;
    }

    public void getJobInfo(){
        JobInfo.Builder ex = new JobInfo.Builder(8888, new ComponentName(this.getPackageName(), GuardJobService.class.getName()));

        ex.setPeriodic(500L); //设置执行间隔时间
        //ex.setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE); //设置需要的网络环境
        //ex.setMinimumLatency(3000);                            // 设置任务运行最少延迟时间
        //ex.setRequiresCharging(true);                         //设置是否在充电的时候执行
        JobScheduler jobScheduler = (JobScheduler)this.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        int ret = jobScheduler.schedule(ex.build());

        Log.e("service","GuardJobService--getJobInfo -- ret::" + ret);
    }


}
