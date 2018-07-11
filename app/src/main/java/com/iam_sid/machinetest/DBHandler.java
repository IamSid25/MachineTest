package com.iam_sid.machinetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    Context context;
    // Database Name
    private static final String DATABASENAME="UsersDb";
    private  static final int DATABASEVERSION=1;

    public DBHandler(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    public static final String TABLE_USERS="users";
    public static final String KEY_NAME="users_name";
    public static final String KEY_EMAIL="users_email";
    public static final String KEY_PHONE_NO="users_id";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS +"("
                + KEY_NAME+" TEXT, "
                + KEY_EMAIL+" TEXT,"
                + KEY_PHONE_NO+" TEXT" +")";
        sqLiteDatabase.execSQL(CREATE_USERS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean insert_users(Users users)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, users.getName());
        contentValues.put(KEY_EMAIL,users.getEmail());
        contentValues.put(KEY_PHONE_NO,users.getNumber());
        long result=db.insert(TABLE_USERS,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public Cursor getAlldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res= db.rawQuery("SELECT * FROM "+TABLE_USERS,null);
        return res;
    }
}
