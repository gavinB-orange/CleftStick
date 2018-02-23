package com.example.brebner.cleftstick;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by brebner on 20-Feb-18.
 */

@Dao
public interface NotesDAO {

    @Query("SELECT * FROM NoteEntry")
    List<NoteEntry> getAll();

    @Insert
    void insertAll(NoteEntry...notes);

    @Delete
    void delete(NoteEntry noteEntry);

}
