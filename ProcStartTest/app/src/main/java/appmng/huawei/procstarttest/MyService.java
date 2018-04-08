package appmng.huawei.procstarttest;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by iceice on 2018/4/9.
 */

public class MyService extends Service {
    private static final String TAG = "ProcStartTest";
    private int pid = android.os.Process.myPid();

    @Override
    public void onCreate(){
        Log.i(TAG,"MyService is oncreate====="+"pid="+pid);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String processName = "";
        ActivityManager mActivityManager = (ActivityManager)this.getSystemService(getApplicationContext().ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcessInfo : mActivityManager.getRunningAppProcesses()) {
            if (appProcessInfo.pid == pid) {
                processName = appProcessInfo.processName;
            }
        }
        if("appmng.huawei.procstarttest:Service".equals(processName)){
            Log.i(TAG, "processName="+processName+"-----work");
        }else{
            Log.i(TAG, "processName="+processName+"-----work");
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"MyServices is OnDestory");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
