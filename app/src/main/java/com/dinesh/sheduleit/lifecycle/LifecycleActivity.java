package com.dinesh.sheduleit.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityLifecycleBinding;
import com.dinesh.sheduleit.livedata.LiveDataActivity;
import com.dinesh.sheduleit.viewModel.ViewModelActivity;

public class LifecycleActivity extends AppCompatActivity{

    private String TAG=this.getClass().getSimpleName();
    private ActivityLifecycleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_lifecycle);
        Log.i(TAG, "onCreate: ");
        binding.setClickListener(new LifecycleActivityListener());

        getLifecycle().addObserver(new MyLifecycleObserver());
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    public class LifecycleActivityListener{
        public void onViewModelClick(){
            startActivity(new Intent(getApplicationContext(),ViewModelActivity.class));
        }
        public void onLiveDataClick(){
            startActivity(new Intent(getApplicationContext(), LiveDataActivity.class));
        }
    }
}
