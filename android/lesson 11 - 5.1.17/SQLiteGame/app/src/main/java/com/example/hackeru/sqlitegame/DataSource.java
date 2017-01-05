package com.example.hackeru.sqlitegame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by hackeru on 1/5/2017.
 */

public class DataSource {

    private SQLiteDatabase db;

    public DataSource(Context context){
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public long insert(String name, int score){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLUMN_NAME, name);
        values.put(DBOpenHelper.COLUMN_SCORE, score);
        return db.insert(
                DBOpenHelper.TABLE_SCORES,
                null,
                values
        );
    }

    public int update(int id, String newName){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLUMN_NAME, newName);
        return db.update(
                DBOpenHelper.TABLE_SCORES,
                values,
                DBOpenHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}
        );
    }

    public int delete(int id){
        return db.delete(
                DBOpenHelper.TABLE_SCORES,
                DBOpenHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}
        );
    }

    public Cursor getAllData(){
        Cursor cursor =  db.query(
                DBOpenHelper.TABLE_SCORES,
                null,
                null,
                null,
                null,
                null,
                DBOpenHelper.COLUMN_SCORE + " DESC"
        );
        /*
        Log.d("Maayan", "in getAllData");
        if (cursor != null && cursor.getCount() >= 1){
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME));
                int score = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COLUMN_SCORE));
                Log.d("Maayan", "The score for " + name + " is: " + score);
            }
        }
        */
        return cursor;
    }

}
