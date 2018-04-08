package appmng.huawei.procstarttest;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MyApplication extends AppCompatActivity {
    private static final String TAG = "ProcStartTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_application);
        int pid = android.os.Process.myPid();
        Log.i(TAG, "MyApplication is oncreate====="+"pid="+pid);
        String processName = "";
        ActivityManager mActivityManager = (ActivityManager)this.getSystemService(getApplicationContext().ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcessInfo : mActivityManager.getRunningAppProcesses()) {
            if (appProcessInfo.pid == pid) {
                processName = appProcessInfo.processName;
            }
        }
        if("appmng.huawei.procstarttest".equals(processName)){
            Log.i(TAG, "processName="+processName+"-----work");
        }else{
            Log.i(TAG, "processName="+processName+"-----work");
        }

    }
}

