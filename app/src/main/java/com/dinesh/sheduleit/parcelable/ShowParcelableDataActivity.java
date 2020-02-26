package com.dinesh.sheduleit.parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityShowParcelableDataBinding;

public class ShowParcelableDataActivity extends AppCompatActivity {

    private ActivityShowParcelableDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_show_parcelable_data);

        Intent i=getIntent();
        MyParcelableModel model=i.getParcelableExtra("MyItems");

        int imageRes=model.getImage();
        String line1=model.getmText1();
        String line2=model.getmText2();

        binding.image.setImageResource(imageRes);
        binding.tv1.setText(line1);
        binding.tv2.setText(line2);

    }
}
