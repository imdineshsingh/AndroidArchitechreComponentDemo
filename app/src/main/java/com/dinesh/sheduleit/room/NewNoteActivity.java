package com.dinesh.sheduleit.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityNewNoteBinding;

public class NewNoteActivity extends AppCompatActivity {

    public static final String NOTE_ADDED = "NOTE_ADDED";
    private ActivityNewNoteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_new_note);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent=new Intent();
                if (TextUtils.isEmpty(binding.etNote.getText())){
                    setResult(RESULT_CANCELED,resultIntent);
                }else {
                    String note=binding.etNote.getText().toString();
                    resultIntent.putExtra(NOTE_ADDED,note);
                    setResult(RESULT_OK,resultIntent);
                }
                finish();
            }
        });

    }
}
