package com.example.appstute_pc.registartionform.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Appstute-PC on 12-10-2017.
 */

public class DBSave extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static final String DB_NAME="register";
    private static final String TABLE_NAME="employee";
    private static final String ID="key_id";
    private static final String NAME="name";
    private static final String USERNAME="username";
    private static final String PASSWORD="password";
    DBPojo pojo=new DBPojo();

    public DBSave(Context context){
        super(context,DB_NAME,null,DB_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table="create table "+TABLE_NAME+"( "+NAME+" text, "+USERNAME+" text, "+PASSWORD+" text)";
        addNewRecord(pojo);
        getData();
    }

    private List<DBPojo> getData() {
        List<DBPojo> record=new ArrayList<DBPojo>();
        String selectQuery="select * from "+TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                DBPojo pojo=new DBPojo();
                pojo.setName(cursor.getString(1));
                pojo.setUsername(cursor.getString(2));
                pojo.setPassword(cursor.getString(3));
                record.add(pojo);

            }while (cursor.moveToNext());
        }
        return record;
    }

    private void addNewRecord(DBPojo pojo) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
       // contentValues.put(ID,pojo.getId());
        contentValues.put(NAME,pojo.getName());
        contentValues.put(USERNAME,pojo.getUsername());
        contentValues.put(PASSWORD,pojo.getPassword());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
