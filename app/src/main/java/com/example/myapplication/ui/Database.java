package com.example.myapplication.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private Context context;
    public String db_name="database.db";
    private static final int db_version= 1;
    private static final String table_name="notificationadhkar";
    private static final String column_adhkar="dhikr";
    public Database(@Nullable Context context) {
        super(context, table_name, null, db_version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query= "create table "+ table_name + "(" + column_adhkar + " TEXT );";
    db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL(" DROP TABLE IF EXISTS " + table_name);
    onCreate(db);
    }
    public void adddhikr(String dhikr){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues value=new ContentValues();
        value.put(column_adhkar, dhikr);
        long result =db.insert(table_name,null,value);
        if(result == -1)
            Toast.makeText(context,"added failled",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"added succes",Toast.LENGTH_LONG).show();

    }
    public Cursor getdata(){
        String query = " SELECT *FROM " + table_name ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=null;
        if(db!=null)
        {
            cursor=db.rawQuery(query,null);

        }
        return cursor;

    }
}
