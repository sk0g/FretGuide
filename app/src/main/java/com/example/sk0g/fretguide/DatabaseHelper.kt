package com.example.sk0g.fretguide

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder

class DatabaseHelper : SQLiteOpenHelper {

    companion object {
        val DB_NAME     = "RecentTunings.db"
        val DB_VERSION  = 1

        val TABLE_NAME      = "tuningsTable"
        val NOTES_COLUMN    = "NOTES_COLUMN"
        val TIME_COLUMN     = "TIME_COLUMN"
        val NAME_COLUMN     = "NAME_COLUMN"
        val TYPE_COLUMN     = "TYPE_COLUMN"

        private val SQL_CREATE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " " + "(" +
                NOTES_COLUMN + " TEXT, " + TIME_COLUMN + " INTEGER PRIMARY KEY, " +
                NAME_COLUMN + " TEXT, " + TYPE_COLUMN + " TEXT );"
    }

    var context: Context? = null
    var sqlObj: SQLiteDatabase

    constructor(context: Context) : super(context, DB_NAME, null, DB_VERSION) {
        this.context = context
        sqlObj = this.writableDatabase
    }

    override fun onCreate(db: SQLiteDatabase) {
        // TODO: Initialise with values
        db.execSQL(SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        throw RuntimeException("This shouldn't be happening. Implement onUpgrade() pl0x")
    }

    fun getTunings(keyword: String): ArrayList<TuningModel> {
        var arrayList = ArrayList<TuningModel>()

        val builder = SQLiteQueryBuilder()
        builder.tables = TABLE_NAME
        val columns = arrayOf(NOTES_COLUMN, TIME_COLUMN, NAME_COLUMN, TYPE_COLUMN)
        val rowSelectArgument = arrayOf(keyword)

        return arrayList
    }

    fun addTuning(tuning: TuningModel) {
        val values = ContentValues()

        values.put(NOTES_COLUMN, tuning.notes)
        values.put(TIME_COLUMN, tuning.time)
        values.put(NAME_COLUMN, tuning.name)
        values.put(TYPE_COLUMN, tuning.type)

        sqlObj.insert(TABLE_NAME, null, values)
        sqlObj.close()
    }
}