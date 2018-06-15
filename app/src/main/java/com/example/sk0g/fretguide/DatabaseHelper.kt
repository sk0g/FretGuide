package com.example.sk0g.fretguide

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

public class DatabaseHelper : SQLiteOpenHelper {
    val DATABASE_NAME = "recent_tunings.db"
    val SCHEMA = 1
    val TUNING = "tuning"
    val TIME   = "time"
    val NAME   = "name"

    @Override fun OnCreate(db: SQLiteDatabase) {
        // TODO: Initialise with values
    }

    public DatabaseHelper(context: Context) {
        super(context, DATABASE_NAME, null, SCHEMA)
    }
}