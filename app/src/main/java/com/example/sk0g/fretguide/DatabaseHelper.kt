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

//class DatabaseHelper : SQLiteOpenHelper {
//
//    companion object {
//        val DB_NAME     = "RecentTunings.db"
//        val DB_VERSION  = 1
//
//        val TABLE_NAME      = "tuningsTable"
//        val NOTES_COLUMN    = "NOTES_COLUMN"
//        val TIME_COLUMN     = "TIME_COLUMN"
//        val NAME_COLUMN     = "NAME_COLUMN"
//        val TYPE_COLUMN     = "TYPE_COLUMN"
//
//        private val SQL_CREATE_TABLE =
//                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " " + "(" +
//                NOTES_COLUMN + " TEXT, " + TIME_COLUMN + " INTEGER PRIMARY KEY, " +
//                NAME_COLUMN + " TEXT, " + TYPE_COLUMN + " TEXT );"
//    }
//
//    var context: Context? = null
//    var sqlObj: SQLiteDatabase
//
//    constructor(context: Context) : super(context, DB_NAME, null, DB_VERSION) {
//        this.context = context
//        sqlObj = this.writableDatabase
//    }
//
//    override fun onCreate(db: SQLiteDatabase) {
//        // TODO: Initialise with values
//        db.execSQL(SQL_CREATE_TABLE)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        throw RuntimeException("This shouldn't be happening. Implement onUpgrade() pl0x")
//    }
//
//    fun getTunings(keyword: String): ArrayList<TuningModel> {
//        var arrayList = ArrayList<TuningModel>()
//
//        val builder = SQLiteQueryBuilder()
//        builder.tables = TABLE_NAME
//        val columns = arrayOf(NOTES_COLUMN, TIME_COLUMN, NAME_COLUMN, TYPE_COLUMN)
//        val rowSelectArgument = arrayOf(keyword)
//
//        return arrayList
//    }
//
//    fun addTuning(tuning: TuningModel) {
//        val values = ContentValues()
//
//        // TODO: Check if tuning already in table. If so, update the timestamp instead
//
//        values.put(NOTES_COLUMN, tuning.notes)
//        values.put(TIME_COLUMN, tuning.time)
//        values.put(NAME_COLUMN, tuning.name)
//        values.put(TYPE_COLUMN, tuning.type)
//
//        sqlObj.insert(TABLE_NAME, null, values)
//        sqlObj.close()
//    }
//}
