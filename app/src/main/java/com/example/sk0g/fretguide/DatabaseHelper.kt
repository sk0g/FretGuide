package com.example.sk0g.fretguide

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DatabaseHelper(context: Context) : ManagedSQLiteOpenHelper(context, "TuningsDB") {

    companion object {
        private var instance: DatabaseHelper? = null
        private const val tableName  = "tuningsTable"
        private const val noteColumn = "notes"
        private const val timeColumn = "time"
        private const val nameColumn = "name"
        private const val typeColumn = "type"

        @Synchronized
        fun getInstance(context: Context): DatabaseHelper {
            if (instance == null) {
                instance = DatabaseHelper(context.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(tableName, true,
                noteColumn to TEXT,
                timeColumn to INTEGER + PRIMARY_KEY + UNIQUE,
                nameColumn to TEXT,
                typeColumn to TEXT)

        db.insert(tableName,
                noteColumn to "EADGBE",
                timeColumn to System.currentTimeMillis(),
                nameColumn to "E Standard",
                typeColumn to "preset")

        db.insert(tableName,
                noteColumn to "DADGBE",
                timeColumn to System.currentTimeMillis(),
                nameColumn to "Drop D",
                typeColumn to "preset")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        throw RuntimeException("This shouldn't be happening. Implement onUpgrade() pl0x")
    }
}

val Context.database: DatabaseHelper
get() = DatabaseHelper.getInstance(applicationContext)
