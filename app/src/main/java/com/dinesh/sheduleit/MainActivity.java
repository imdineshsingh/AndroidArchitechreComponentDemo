package com.dinesh.sheduleit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dinesh.sheduleit.databinding.ActivityMainBinding;
import com.dinesh.sheduleit.galleryMultipleImagePick.GalleryActivity;
import com.dinesh.sheduleit.lifecycle.LifecycleActivity;
import com.dinesh.sheduleit.livedata.LiveDataActivity;
import com.dinesh.sheduleit.room.NotesActivity;
import com.dinesh.sheduleit.test.MyInterface;
import com.dinesh.sheduleit.test.TestInterfacesActivity;
import com.dinesh.sheduleit.threading.MyThreadActivity;
import com.dinesh.sheduleit.threading.handlerLooperMessageQueue.HandlerExampleActivity;
import com.dinesh.sheduleit.viewModel.ViewModelActivity;

public class MainActivity extends AppCompatActivity implements MyInterface {


    private ActivityMainBinding binding;
    private String TAG=this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.setClickListener(new MainActivityClickListner());
    }

    @Override
    public void changeBgColor() {
        //binding.relativeLayout.setBackgroundColor(Color.GREEN);
        //Toast.makeText(getApplicationContext(), "MainActivity interface executed", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "changeBgColor: ");
        //binding.tvRecycleComp.setText("Interface executed");

    }


    public class MainActivityClickListner{

        public void onClick(View v){
            switch (v.getId()){
                case R.id.btnLiveData:
                    startActivity(new Intent(getApplicationContext(), LiveDataActivity.class));
                    break;
                case R.id.btnViewModel:
                    startActivity(new Intent(getApplicationContext(), ViewModelActivity.class));
                    break;

                case R.id.btnLifecycle:
                    startActivity(new Intent(getApplicationContext(), LifecycleActivity.class));
                    break;
                case R.id.btnTestInterface:
                    startActivity(new Intent(getApplicationContext(), TestInterfacesActivity.class));
                    break;

                case R.id.btnRoom:
                    startActivity(new Intent(getApplicationContext(), NotesActivity.class));
                    break;
                case R.id.btnThreding:
                    startActivity(new Intent(getApplicationContext(), MyThreadActivity.class));
                    break;

                case R.id.btnHandler:
                    startActivity(new Intent(getApplicationContext(), HandlerExampleActivity.class));
                    break;

                case R.id.btnMultipleImageSelection:
                    startActivity(new Intent(getApplicationContext(), GalleryActivity.class));
                    break;

                default:break;
            }

        }
    }
}
