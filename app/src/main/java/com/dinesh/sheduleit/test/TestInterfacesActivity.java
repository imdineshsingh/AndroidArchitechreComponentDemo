package com.dinesh.sheduleit.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.dinesh.sheduleit.MainActivity;
import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityTestInterfacesBinding;

public class TestInterfacesActivity extends AppCompatActivity implements MyButtonClickListenerInterface {

    private ActivityTestInterfacesBinding binding;
    private MyInterface myInterface;
    private Context context;
    public MyButtonClickListenerInterface myButtonClickListenerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_test_interfaces);
        context=TestInterfacesActivity.this;

        //initialize interfaces
        //myInterface= (MyInterface) this;
        myButtonClickListenerInterface=this;

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //myInterface.changeBgColor();
                //new MainActivity().changeBgColor();
                //(new TestInterfacesActivity()).alertForDiscardDefaultProfileChang‌​‌​es(id);

                //myInterface.changeBgColor();
            }
        });


        binding.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myButtonClickListenerInterface.pressedYes();
            }
        });

        binding.btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myButtonClickListenerInterface.pressedNo();
            }
        });
    }


    @Override
    public void pressedYes() {
        binding.tvText.setText("Yes Clicked");
    }
    @Override
    public void pressedNo() {
        binding.tvText.setText("No Clicked");
    }
}



interface MyButtonClickListenerInterface{
    void pressedYes();
    void pressedNo();
}