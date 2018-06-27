package com.example.sk0g.fretguide

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder

class DatabaseHelper : SQLiteOpenHelper {

    companion object {
        val DB_NAME = "RecentTunings.db"
        val DB_VERSION = 1

        val tableName   = "tuningsTable"
        val tuning      = "tuning"
        val time        = "time"
        val name        = "name"
        val type        = "type"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE IF NOT EXISTS " + tableName + " " + "(" +
                tuning + " TEXT, " + time + " INTEGER PRIMARY KEY, " +
                name + " TEXT, " + type + " TEXT );"
    }

    var context: Context? = null
    var sqlObj: SQLiteDatabase

    constructor(context: Context) : super(context, DB_NAME, null, DB_VERSION) {
        this.context = context
        sqlObj = this.writableDatabase
    }

    override fun onCreate(db: SQLiteDatabase) {
        // TODO: Initialise with values
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        throw RuntimeException("This shouldn't be happening. Implement onUpgrade() pl0x")
    }

    fun getTunings(keyword: String): ArrayList<TuningModel> {
        var arrayList = ArrayList<TuningModel>()

        val builder = SQLiteQueryBuilder()
        builder.tables = tableName
        val columns = arrayOf(tuning, time, name, type)
        val rowSelectArgument = arrayOf(keyword)

        return arrayList
    }
}