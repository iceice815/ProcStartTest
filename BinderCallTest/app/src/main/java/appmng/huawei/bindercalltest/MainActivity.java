package appmng.huawei.bindercalltest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "BinderCallTest";
    ServiceConnection mSc;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button)findViewById(R.id.button) ;
        mSc = new ServiceConnection(){
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d(TAG, "service connected");
                LocalService ss = ((LocalService.LocalBinder)service).getService();
                ss.sayHelloWorld();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(TAG, "service disconnected");
            }
        };
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "BinderService");
//                Intent service = new Intent(MainActivity.this.getApplicationContext(),LocalService.class);
//                MainActivity.this.bindService(service, mSc, Context.BIND_AUTO_CREATE);
//            }
//        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, this.getApplicationContext().getPackageCodePath());
        Intent service = new Intent(this.getApplicationContext(),LocalService.class);
        this.bindService(service, mSc, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
