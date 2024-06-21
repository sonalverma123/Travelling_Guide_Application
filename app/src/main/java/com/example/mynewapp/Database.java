package com.example.mynewapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String DBname = "records.db";
    public static final String TABLE_NAME = "users";
    public static final String COL_1 = "id";
    public static final String COL_2 = "firstname";
    public static final String COL_3 = "secondname";
    public static final String COL_4 = "password";
    public static final String COL_5 = "dob";
    public static final String COL_6 = "email";
    public static final String COL_7 = "phone";


    public Database(Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//oncreate method jo apka har bar execute nhi hota
        db.execSQL("create table " + TABLE_NAME + " (" + COL_1 + " INTEGER  PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT," + COL_3 + " TEXT," + COL_4 + " TEXT," + COL_5 + " TEXT," + COL_6 + " TEXT," + COL_7 + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
    }

    public boolean insertUser(String firstname, String secondname, String password, String dob, String email, String phone) {
        boolean flag = false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, firstname);
        cv.put(COL_3, secondname);
        cv.put(COL_4, password);
        cv.put(COL_5, dob);
        cv.put(COL_6, email);
        cv.put(COL_7, phone);

        long res = db.insert(TABLE_NAME, null, cv);
        db.close();

        if (res != -1)
            flag = true;


        return flag;
    }

    public Cursor getProfile(String email) {//all work is done from cursor in database
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME +" where email='"+email+"'", null);
        return cursor;
    }

    public boolean checkUserExist(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME+" where email='"+username+"' and password='"+password+"'",null );

        int count = cursor.getCount();

        cursor.close();
        close();

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }
}
