package com.dinesh.sheduleit.room;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class NoteViewModel extends AndroidViewModel { //we ll user AndroidViewModel so that we can get Application context

    private String TAG=this.getClass().getSimpleName();
    private NoteDao noteDao;
    private NoteRoomDatabase noteDB;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        //creating instance for DB and Dao
        noteDB=NoteRoomDatabase.getDatabase(application);
        noteDao=noteDB.noteDao();
    }

    public void insert(NoteEntity note){
        //as we need to do insrtion in nonUI thread so we'll use Async task
        new InsertAsyncTask(noteDao).execute(note);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "onCleared: ");
    }


    private static class InsertAsyncTask extends AsyncTask<NoteEntity,Void,Void> {

        NoteDao noteDao;
        InsertAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }

        @Override
        protected Void doInBackground(NoteEntity... noteEntities) {
            noteDao.insert(noteEntities[0]);
            return null;
        }
    }
}
