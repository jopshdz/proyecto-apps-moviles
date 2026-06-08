package com.saintleo.kidquest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.saintleo.kidquest.KidProfileContract.ProfileEntry

class KidQuestDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${ProfileEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${ProfileEntry.COLUMN_NAME_NOMBRE} TEXT," +
                "${ProfileEntry.COLUMN_NAME_EDAD} INTEGER," +
                "${ProfileEntry.COLUMN_NAME_CUMPLEANOS} TEXT," +
                "${ProfileEntry.COLUMN_NAME_GENERO} TEXT," +
                "${ProfileEntry.COLUMN_NAME_AVATAR_ID} INTEGER," +
                "${ProfileEntry.COLUMN_NAME_MONEDAS} INTEGER DEFAULT 0," +
                "${ProfileEntry.COLUMN_NAME_FIREBASE_KEY} TEXT)"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${ProfileEntry.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "KidQuest.db"
    }
}