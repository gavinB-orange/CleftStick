/**
 * Created by brebner on 20-Feb-18.
 */

package com.example.brebner.cleftstick;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity
public class NoteEntry {

    @PrimaryKey
    private int id;

    @ColumnInfo
    private Float longitude;

    @ColumnInfo
    private Float latitude;

    @ColumnInfo
    private Float distance;

    @ColumnInfo
    private String message;

    public void setId(int i) { id = i; }

    public void setLongitude(Float l) { longitude = l; }

    public void setLatitude(Float l) { latitude = l; }

    public void setDistance(Float d) { distance = d; }

    public void setMessage(String m) { message = m; }

    public int getId() { return id; }

    public Float getLongitude() { return longitude; }

    public Float getLatitude() { return latitude; }

    public Float getDistance() { return distance; }

    public String getMessage() { return message; }

}
