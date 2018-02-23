package com.example.brebner.cleftstick;

import android.app.Application;
import android.arch.persistence.room.Room;

/**
 * Created by brebner on 23-Feb-18.
 */

public class CleftStickApp extends Application {

    NotesDatabase notesDatabase = null;

    @Override
    public void onCreate() {
        super.onCreate();
        notesDatabase = Room.databaseBuilder(this,
                                              NotesDatabase.class,
                                             "notes-database").build();
    }

    public NotesDatabase getNotesDatabase() {
        return notesDatabase;
    }

}
