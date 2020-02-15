package com.dinesh.sheduleit.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifecycleObserver implements androidx.lifecycle.LifecycleObserver {
    private String TAG=this.getClass().getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateEvent(){
        Log.i(TAG, "onCreateEvent: ");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartEvent(){
        Log.i(TAG, "onStartEvent: ");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeEvent(){
        Log.i(TAG, "onResumeEvent: ");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseEvent(){
        Log.i(TAG, "onPauseEvent: ");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopEvent(){
        Log.i(TAG, "onStopEvent: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void  onDestroyEvent(){
        Log.i(TAG, "onDestroyEvent: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAnyEvent(){
        Log.i(TAG, "onAnyEvent: ");  //invoke on any lifecycle event triggr
    }
}