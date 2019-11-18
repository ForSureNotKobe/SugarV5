package com.example.sugarv5.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SugarBase.db";
    public static final String TABLE_NAME = "Measures_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MEASURE";
    public static final String COL_3 = "NOTE";
    public static final String COL_4 = "DATE";
    public static final String COL_5 = "TIME";

    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE table "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, MEASURE INTEGER, NOTE TEXT, DATE TEXT,TIME TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData (String measure, String note, String date,String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, measure);
        contentValues.put(COL_3, note);
        contentValues.put(COL_4, date);
        contentValues.put(COL_5, time);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY ID DESC", null);
        return res;
    }
}
