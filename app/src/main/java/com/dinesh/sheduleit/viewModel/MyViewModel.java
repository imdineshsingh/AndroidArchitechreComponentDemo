package com.dinesh.sheduleit.viewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MyViewModel extends ViewModel {
    private String TAG=this.getClass().getSimpleName();
    private String myRandomNumer;

    public String getNumber(){
        Log.i(TAG, "getNumber: ");
        if (myRandomNumer==null){
            generateNumber();
        }
        return myRandomNumer;
    }
    private void generateNumber() {
        Log.i(TAG, "generateNumber: ");
        Random random=new Random();
        myRandomNumer="Number"+(random.nextInt(10-1)+1);
    }

    public Integer generateNewNumber(){
        return new Random().nextInt();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "onCleared: ViewModel");
    }
}