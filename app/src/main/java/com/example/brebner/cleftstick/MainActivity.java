package com.example.brebner.cleftstick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w("MainActivity", "OnStart");
    }

    public void onAddNotes(View view) {
        Intent addNotesIntent = new Intent(this, AddNotesActivity.class);
        startActivity(addNotesIntent);
    }
}
