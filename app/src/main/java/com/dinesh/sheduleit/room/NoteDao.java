package com.dinesh.sheduleit.room;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface NoteDao {

    //creating method for inserting notes to the roomDB

    @Insert
    void insert(NoteEntity note);  //we need to create wrapper for this insert method in our viewmodel
}
