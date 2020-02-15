package com.dinesh.sheduleit.viewModel;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityViewModelBinding;

public class ViewModelActivity extends AppCompatActivity {

    private ActivityViewModelBinding binding;
    private MyViewModel viewModel;
    private String TAG=this.getClass().getSimpleName();
    String randomNumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_view_model);

        //dataGenerator=new MyViewModel();       //without ViewModel

        /*
        *Below-:
        *Here we are creating instance(object) of view Model
        * and through the object we can access data from view model
         */
        viewModel=new ViewModelProvider(this).get(MyViewModel.class); //with ViewModel

        randomNumber= viewModel.getNumber();
        binding.myTv.setText(randomNumber);

        binding.setMyClickListener(this); //setClickListener using concept of Data Binding
        //here "this" representing new ViewModelActivity()  ie. object of current class
    }

    //generate random Number onbutton click
    public void onGenerateClick(){
        binding.tvNewNumber.setText(""+viewModel.generateNewNumber());
    }
}