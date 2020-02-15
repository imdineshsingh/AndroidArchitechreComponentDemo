package com.dinesh.sheduleit.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class NoteEntity {
    //will have two columns , one for id, and one for note

    @PrimaryKey                        //making id as primary key  which will be notnull
    @NonNull
    private String id;
    @NonNull
    @ColumnInfo(name = "note")                     //annotation @ColumnInfo used to change columnName for a particular field .
    public String mNote;


    //now we need a constructor and a getter method for this datamodel class
    //Room will use the constructor and getter method to instantiate our NoteEntity object


    public NoteEntity(@NonNull String id, @NonNull String mNote) {
        this.id = id;
        this.mNote = mNote;
    }


    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getmNote() {
        return mNote;
    }
}
