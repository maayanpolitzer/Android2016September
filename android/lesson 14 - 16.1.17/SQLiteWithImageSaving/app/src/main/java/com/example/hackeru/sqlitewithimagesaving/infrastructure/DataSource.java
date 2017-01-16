package com.example.hackeru.sqlitewithimagesaving.infrastructure;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hackeru on 1/16/2017.
 */

public class DataSource {

    private SQLiteDatabase db;

    public DataSource(Context context){
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public long insert(String name, String phone, String fileName){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COL_NAME, name);
        values.put(DBOpenHelper.COL_PHONE, phone);
        values.put(DBOpenHelper.COL_IMAGE_FILE_URI, fileName);
        long id =  db.insert(DBOpenHelper.TABLE_CONTACTS_NAME, null, values);
        db.close();
        return id;
    }

    public int delete(int id){
        int rowsDeleted = db.delete(
                DBOpenHelper.TABLE_CONTACTS_NAME,
                DBOpenHelper.COL_ID + "=?",
                new String[]{String.valueOf(id)}
                /*
                DBOpenHelper.COL_NAME + "=? AND " + DBOpenHelper.COL_PHONE + "=?",
                new String[]{"moshe", "0523453456"}
                */
                );
        return rowsDeleted;
    }

    public Cursor getData(){
        return db.query(
                DBOpenHelper.TABLE_CONTACTS_NAME,
                null,
                null,
                null,
                null,
                null,
                null   // "_id ASC" -> "name DESC"
        );
    }

    public Cursor getContact(int id){
        return db.query(
                DBOpenHelper.TABLE_CONTACTS_NAME,
                null,
                DBOpenHelper.COL_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );
    }

    public int update(int id, String newName, String newPhone, String newImage){
        ContentValues values = new ContentValues();
        if (newName != null){
            values.put(DBOpenHelper.COL_NAME, newName);
        }
        if (newPhone != null){
            values.put(DBOpenHelper.COL_PHONE, newPhone);
        }
        if (newImage != null){
            values.put(DBOpenHelper.COL_IMAGE_FILE_URI, newImage);
        }
        return update(id, values);
    }

    public int update(int id, ContentValues values){
        int rowsAffected = db.update(
                DBOpenHelper.TABLE_CONTACTS_NAME,
                values,
                DBOpenHelper.COL_ID + "=?",
                new String[]{String.valueOf(id)}
        );
        return rowsAffected;
    }

}










