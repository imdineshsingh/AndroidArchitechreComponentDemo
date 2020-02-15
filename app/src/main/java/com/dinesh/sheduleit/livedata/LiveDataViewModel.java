package com.dinesh.sheduleit.livedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class LiveDataViewModel extends ViewModel {
    private String TAG=this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumer;  //STEP 1: Create instance of LiveData or MutableLiveData
                                                    //MutableLiveData class constains setValue() and postValue() methods

    public MutableLiveData<String> getNumber(){
        Log.i(TAG, "getNumber: ");
        if (myRandomNumer==null){
            myRandomNumer= new MutableLiveData<>();
            generateNumber();
        }
        return myRandomNumer;
    }
    public void generateNumber() {
        Log.i(TAG, "generateNumber: ");
        Random random=new Random();
        //myRandomNumer="Number"+(random.nextInt(10-1)+1);
        myRandomNumer.setValue(""+(random.nextInt(10-1)+1));      //Use setValue to setValues....
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "onCleared: ViewModel");
    }
}
