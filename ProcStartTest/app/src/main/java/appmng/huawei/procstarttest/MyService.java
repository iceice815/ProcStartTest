package appmng.huawei.procstarttest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by iceice on 2018/4/9.
 */

public class MyService extends Service {
    private static final String TAG = "ProcStartTest";

    @Override
    public void onCreate(){
        Log.i(TAG,"MyService is oncreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int pid = android.os.Process.myPid();
        Log.i(TAG, "MyServices is created====="+"pid="+pid);
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
