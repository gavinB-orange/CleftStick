package com.example.brebner.cleftstick;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by brebner on 20-Feb-18.
 */

@Database(entities = {NoteEntry.class}, version=1)
public abstract class NotesDatabase extends RoomDatabase {
    public abstract NotesDAO notesDAO();
}

