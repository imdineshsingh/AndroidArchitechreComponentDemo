package com.dinesh.sheduleit.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityNotesBinding;

import java.util.UUID;

public class NotesActivity extends AppCompatActivity {

    private ActivityNotesBinding binding;
    private NoteViewModel noteViewModel;
    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 100;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_notes);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NotesActivity.this,NewNoteActivity.class);
                startActivityForResult(intent,NEW_NOTE_ACTIVITY_REQUEST_CODE);

            }
        });

        noteViewModel= new ViewModelProvider(this).get(NoteViewModel.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode==RESULT_OK){

            //Code to insert note
            final String note_id= UUID.randomUUID().toString();
            NoteEntity note=new NoteEntity(note_id, data.getStringExtra(NewNoteActivity.NOTE_ADDED));
            noteViewModel.insert(note);

            Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, R.string.not_saved, Toast.LENGTH_SHORT).show();
        }
    }
}
