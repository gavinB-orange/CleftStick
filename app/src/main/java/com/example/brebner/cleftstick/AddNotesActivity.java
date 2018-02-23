package com.example.brebner.cleftstick;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.util.List;


public class AddNotesActivity extends AppCompatActivity {

    private NotesDAO notesDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
    }

    public void onAddClick(View view) {
        new Thread(new Runnable() {
            public void run() {
                NotesDatabase notesDatabase = ((CleftStickApp) getApplication()).getNotesDatabase();
                notesDAO = notesDatabase.notesDAO();
                NoteEntry ne = new NoteEntry();
                EditText lat_edit_text = (EditText) findViewById(R.id.editTextLatitude);
                EditText long_edit_text = (EditText) findViewById(R.id.editTextLongitude);
                EditText dist_edit_text = (EditText) findViewById(R.id.editTextDistance);
                EditText mess_edit_text = (EditText) findViewById(R.id.editTextAddMessage);
                String lat_text = lat_edit_text.getText().toString();
                String long_text = long_edit_text.getText().toString();
                String dist_text = dist_edit_text.getText().toString();
                String mess_text = mess_edit_text.getText().toString();
                try {
                    ne.setLatitude(Float.parseFloat(lat_text));
                }
                catch (NumberFormatException e) {
                    lat_edit_text.setText("MUST BE NUMBER");
                    return;
                }
                try {
                    ne.setLongitude(Float.parseFloat(long_text));
                }
                catch (NumberFormatException e) {
                    long_edit_text.setText("MUST BE NUMBER");
                    return;
                }
                try {
                    ne.setDistance(Float.parseFloat(dist_text));
                }
                catch (NumberFormatException e) {
                    dist_edit_text.setText("MUST BE NUMBER");
                    return;
                }
                ne.setMessage(mess_text);
                List<NoteEntry> pre_entries = notesDAO.getAll();
                int pre_size = pre_entries.size();
                ne.setId(pre_size);
                notesDAO.insertAll(ne);
                List<NoteEntry> entries = notesDAO.getAll();
                final int size = entries.size();
                TextView countview = findViewById(R.id.textViewNotesCount);
                countview.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView countview = findViewById(R.id.textViewNotesCount);
                        countview.setText(Integer.toString(size));
                    }
                });
            }
        }).start();
    }
}
