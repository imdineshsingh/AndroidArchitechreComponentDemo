package com.dinesh.sheduleit.threading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityMyThreadBinding;

public class MyThreadActivity extends AppCompatActivity {

    private ActivityMyThreadBinding binding;
    private static final String TAG = "MyThreadActivity";   //type logt and get whole line
    private Handler handler=new Handler();

    private volatile boolean stopThread=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_my_thread);
        binding.setMyClickListener(new MyBtnClickListeners());
        //Default thread is main or UI thread
        /*
        *Thread is the sequential execution of a program.if multiple thread are executing its called multithreading.
        *
        *
         */
        //if if we click button and set some long running task before the button set to its default state.. our UI will get freez


    }

    public class MyBtnClickListeners{
        public void onButtonClick(View view){
            switch (view.getId()){
                case R.id.btnStart:
                    //startThread();                                                      //CASE 1          //Normally

                   /* ExampleThread thread=new ExampleThread();                            //CASE 2        //by using Thread ... extending Thread class and and override run method
                    thread.start();*/

                   ExampleRunnable runnable=new ExampleRunnable();                          //CASE 3    //implementing runnable interface to a class and then passing runnable imlementing class object to a Thread class object
                   new Thread(runnable).start();

                    break;
                case R.id.btnStop:
                    stopThread();
                    break;
                    default:
                        break;
            }
        }

        private void stopThread() {
            stopThread=true;
        }

        private void startThread() {        //CASE 1
            //while executing this method we ll not be able to perform other UI actions like we can't press toggle button
            for (int i=0;i<10;i++){
                Log.d(TAG, "startThread: "+i);
                try {
                    Thread.sleep(1000);          //we are freezing UI for 10 sec
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //instead we have to put all this work in background thread
    /*
    There are two ways of starting background thread
   1. eather by extending a Thread class and override run method
   2.or by implementing runnable interface and then passing runnable implementing class object to a Thread class object
   Thread and Runnable are core java classes .There are  also android specific classes like Handler,Looper
   which make running these Thread and communication between different threads more convenient
   there are higher abstraction classes like AsyncTask, HandlerThread, ThreadPoolExecutor
     */
    class ExampleThread extends Thread{             //CASE 2                //Now we can perform background operation as well along with navigating to UI

        @Override
        public void run() {
            for (int i=0;i<10;i++){
                Log.d(TAG, "startThread "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //Creating thread by implementing Runnable interface and provide implementtion for run menthod..
    class ExampleRunnable implements Runnable{                              //CASE 3
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                if (stopThread)
                    return;
                if (i==5){
                    //binding.btnStart.setText("50%");                    //Here we are trying to update UI from our background Thread
                                                                        //This will throw error because.....these UI widgets are not thread safe we can't access them from another thread then the UI thread
                                                    //Exception :android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.

                            //to perform this setText operation on UI we need Handlers
                    //Handler handler=new Handler();        ////if we create object of handler here it won't work Handler needs looper and message queue to work (if we create hadler object inside Thread)
                                                        //we can do this by //Handler threadHandler=new Handler(Looper.getMainLooper());

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            binding.btnStart.setText("50%");
                        }
                    });
                }


                final int finalI = i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyThreadActivity.this, "startThread"+ finalI, Toast.LENGTH_SHORT).show();
                    }
                });

/*
                runOnUiThread(new Runnable() {   //We also can use runOnUiThread() ...to perform operatioin on widget in UI thread
                    @Override
                    public void run() {
                        binding.btnStart.setText("50%");
                    }
                });
*/

                Log.d(TAG, "startThread "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

