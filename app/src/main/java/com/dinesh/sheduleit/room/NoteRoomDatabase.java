package com.dinesh.sheduleit.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = NoteEntity.class,version = 1,exportSchema = false)  //add Entity , our entity class is NoteEntity.class
public abstract class NoteRoomDatabase extends RoomDatabase {     //this class needs to be abstract

    public abstract NoteDao noteDao();

    //create instance of DB , it needs to be singleton
    private static volatile NoteRoomDatabase noteRoomDatabase;
    static NoteRoomDatabase getDatabase(final Context context){
        synchronized (NoteRoomDatabase.class){
            if (noteRoomDatabase==null){
                noteRoomDatabase= Room.databaseBuilder(context.getApplicationContext(),
                        NoteRoomDatabase.class,"note_database")
                        .build();
            }
        }
        return noteRoomDatabase;
    }
}

//IMPORTANT POINTS FOR DATABASE CLASS
/*
* The Database class need to be annotated with @Database annotation, it should include entities associated with DB
* Database class should be abstract and shoud extend RoomDatabase
* it has to have abstract method for each Dao that is related to it....like public abstract NoteDao noteDao; here
* Now we ll Create singletone instance of our Database by using function Room.databaseBuilder()
 */

//So, as component of Room we have Dao(Data Access Object) and Entities
/*
our android application uses Dao to interact with Sqlite Database
* our applicatin uses Dao to perform DB related operation this includes get entity from DB, or persisting the changes to the Db
*our application uses Entities to get or set Field values
 */