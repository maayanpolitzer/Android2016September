package com.example.hackeru.sqlitewithimagesaving.infrastructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hackeru on 1/16/2017.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "maayanDB.db";
    private static final int DB_VERSION = 1;

    public static final String TABLE_CONTACTS_NAME = "Contacts";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_PHONE = "phone";
    public static final String COL_IMAGE_FILE_URI = "imgFileUri";

    private static final String CREATE_TABLE_COMMAND = "CREATE TABLE " + TABLE_CONTACTS_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT, " +
            COL_PHONE + " TEXT, " +
            COL_IMAGE_FILE_URI + " TEXT)";

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("TAG", "Constructor!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_COMMAND);
        Log.d("TAG", "Command: " + CREATE_TABLE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
