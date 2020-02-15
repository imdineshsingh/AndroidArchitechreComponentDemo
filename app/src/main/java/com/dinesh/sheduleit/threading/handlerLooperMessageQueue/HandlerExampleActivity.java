package com.dinesh.sheduleit.threading.handlerLooperMessageQueue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityHandlerExampleBinding;

public class HandlerExampleActivity extends AppCompatActivity {

    private ActivityHandlerExampleBinding binding;
    private static final String TAG = "HandlerExampleActivity";

    private ExampleLooperThread looperThread=new ExampleLooperThread();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_handler_example);
        binding.setClickListeners(new MyButtonClickListeners());

    }

    public class MyButtonClickListeners{
        public void myClickListeners(View view){
            switch (view.getId()){
                case R.id.btnStartThread:
                    looperThread.start(); //ll get crash while pressing again.

                    break;
                case R.id.btnStopThread:

                    break;
                case R.id.btnTaskA:

                    break;

                case R.id.btnTaskB:

                    break;
                    default:break;
            }

        }
    }
}
