package com.dinesh.sheduleit.threading.handlerLooperMessageQueue;

import android.os.SystemClock;
import android.util.Log;

public class ExampleLooperThread extends Thread{

    private static final String TAG = "ExampleLooperThread";
    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            Log.d(TAG, "run: "+i);
            SystemClock.sleep(1000);
        }
        Log.d(TAG, "End of run()");
    }
}
