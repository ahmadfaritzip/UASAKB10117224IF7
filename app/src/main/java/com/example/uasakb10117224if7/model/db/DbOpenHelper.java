package com.example.uasakb10117224if7.model.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


//    Tanggal Pengerjaan : 09-08-2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

public class DbOpenHelper extends SQLiteOpenHelper {
    public DbOpenHelper(Context context) {
        super(context, AppDbHelper.DB_NAME, null, AppDbHelper.DB_VERSION);
//        context.deleteDatabase(AppDbHelper.DB_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDB) {
        String sqlQuery = "CREATE TABLE "+ AppDbHelper.TABLE +" (" +
                AppDbHelper.Columns.C_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AppDbHelper.Columns.C_NAMA +" TEXT, " +
                AppDbHelper.Columns.C_ALAMAT +" TEXT, " +
                AppDbHelper.Columns.C_WEBSITE + " TEXT);";
        Log.d("DataHelper","Query to form table: "+sqlQuery);
        sqlDB.execSQL(sqlQuery);
//        sqlDB.execSQL(AppDbHelper.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
        sqlDB.execSQL("DROP TABLE IF EXISTS "+ AppDbHelper.TABLE);
        Log.d("DataHelper","table: "+sqlDB);
        onCreate(sqlDB);
    }

    public boolean insertData(String nama, String kelas, String telp){
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppDbHelper.Columns.C_NAMA, nama);
        contentValues.put(AppDbHelper.Columns.C_WEBSITE, kelas);
        contentValues.put(AppDbHelper.Columns.C_ALAMAT, telp);

        long result = db.insert(AppDbHelper.TABLE, null, contentValues);

        if (result == -1){ return false; }else{ return true; }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT * FROM "+ DataContact.TABLE ;
//        Cursor data = db.rawQuery(query + "ORDER BY " + DataContact.Columns._ID + " DESC", null);
        Cursor data = db.query(AppDbHelper.TABLE,
                null,
                null,
                null,
                null,
                null,
                AppDbHelper.Columns.C_ID);
        return data;
    }

    public Cursor getData(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("Select * from "+ AppDbHelper.TABLE +" where "+
                AppDbHelper.Columns.C_ID +"=" + id + "", null);
        return data;
    }
}
