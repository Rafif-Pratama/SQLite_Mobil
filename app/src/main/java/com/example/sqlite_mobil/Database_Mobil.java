package com.example.sqlite_mobil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database_Mobil extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "db_mobil";
    private static final String tb_mobil = "tb_mobil";
    private static final String tb_mobil_id = "id";
    private static final String tb_mobil_merk = "merk";
    private static final String tb_mobil_jenis = "jenis";
    private static final String tb_mobil_tahun = "tahun";
    private static final String CREATE_TABLE_MOBIL = "CREATE TABLE " +
            tb_mobil + "("
            + tb_mobil_id + " INTEGER PRIMARY KEY ,"
            + tb_mobil_merk+ " TEXT,"
            + tb_mobil_jenis + " TEXT,"
            + tb_mobil_tahun + " TEXT " + ")";

    public Database_Mobil(Context context){ super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOBIL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateMobil (Mobil mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mobil_id, mdNotif.get_id());
        values.put(tb_mobil_merk, mdNotif.get_merk());
        values.put(tb_mobil_jenis, mdNotif.get_jenis());
        values.put(tb_mobil_tahun, mdNotif.get_tahun());
        db.insert(tb_mobil, null, values);
        db.close();
    }

    public List<Mobil> ReadMobil() {
        List<Mobil> judulModelList = new ArrayList<Mobil>();
        String selectQuery = "SELECT * FROM " + tb_mobil;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Mobil mdKontak = new Mobil();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_merk(cursor.getString(1));
                mdKontak.set_jenis(cursor.getString(2));
                mdKontak.set_tahun(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateMobil (Mobil mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mobil_merk, mdNotif.get_merk());
        values.put(tb_mobil_jenis, mdNotif.get_jenis());
        values.put(tb_mobil_tahun, mdNotif.get_tahun());
        return db.update(tb_mobil, values, tb_mobil_id + " = ?", new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteMobil (Mobil mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_mobil, tb_mobil_id+ " = ?", new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
