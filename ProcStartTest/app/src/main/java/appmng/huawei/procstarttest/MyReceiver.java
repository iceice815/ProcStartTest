package appmng.huawei.procstarttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by iceice on 2018/4/9.
 */

public class MyReceiver extends BroadcastReceiver {
    private final String TAG = "ProcStartTest";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "received intent:" + intent);
        Intent myServiceIntent=new Intent(context,MyService.class);
        context.startService(myServiceIntent);

    }
}
