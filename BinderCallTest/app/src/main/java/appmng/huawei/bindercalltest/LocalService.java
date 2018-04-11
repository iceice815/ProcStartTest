package appmng.huawei.bindercalltest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by iceice on 2018/4/12.
 */

public class LocalService extends Service {

        @Override
        public IBinder onBind(Intent intent) {
            return new LocalBinder();
        }

        public void sayHelloWorld(){
            Toast.makeText(this.getApplicationContext(), "Hello World Local Service!", Toast.LENGTH_SHORT).show();
        }

        public class LocalBinder extends Binder {
            LocalService getService() {
                // Return this instance of LocalService so clients can call public methods
                return LocalService.this;
            }
        }
    }
