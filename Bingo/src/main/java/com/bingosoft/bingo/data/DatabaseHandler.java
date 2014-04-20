package com.bingosoft.bingo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bingosoft.bingo.model.Bingotbl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaime on 2014-04-06.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "BingoManager",
    TABLE_BINGOTBL = "Bingotbl",
    KEY_TBLNRO = "Tblnro",
    KEY_TBLB1 = "Tblb1",
    KEY_TBLB2 = "Tblb2",
    KEY_TBLB3 = "Tblb3",
    KEY_TBLB4 = "Tblb4",
    KEY_TBLB5 = "Tblb5",
    KEY_TBLI1 = "Tbli1",
    KEY_TBLI2 = "Tbli2",
    KEY_TBLI3 = "Tbli3",
    KEY_TBLI4 = "Tbli4",
    KEY_TBLI5 = "Tbli5",
    KEY_TBLN1 = "Tbln1",
    KEY_TBLN2 = "Tbln2",
    KEY_TBLN3 = "Tbln3",
    KEY_TBLN4 = "Tbln4",
    KEY_TBLN5 = "Tbln5",
    KEY_TBLG1 = "Tblg1",
    KEY_TBLG2 = "Tblg2",
    KEY_TBLG3 = "Tblg3",
    KEY_TBLG4 = "Tblg4",
    KEY_TBLG5 = "Tblg5",
    KEY_TBLO1 = "Tblo1",
    KEY_TBLO2 = "Tblo2",
    KEY_TBLO3 = "Tblo3",
    KEY_TBLO4 = "Tblo4",
    KEY_TBLO5 = "Tblo5",
    KEY_TBLANDROID = "Tblandroid",
    TABLE_EXPDATE = "Expdate",
    KEY_INICIODATE = "Iniciodate",
    KEY_FINDATE = "Findate",
    KEY_ACTIVE = "Active";

    public DatabaseHandler (Context context) {
        super(  context,
                DATABASE_NAME,
                null,
                DATABASE_VERSION);
    }


    @Override
    public void onCreate (SQLiteDatabase db) {
        String sqlTbl = "CREATE TABLE " + TABLE_BINGOTBL + "(";
        sqlTbl = sqlTbl + KEY_TBLNRO + " TEXT PRIMARY KEY,";
        sqlTbl = sqlTbl + KEY_TBLB1 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLB2 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLB3 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLB4 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLB5 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLI1 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLI2 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLI3 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLI4 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLI5 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLN1 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLN2 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLN3 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLN4 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLN5 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLG1 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLG2 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLG3 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLG4 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLG5 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLO1 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLO2 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLO3 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLO4 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLO5 + " TEXT,";
        sqlTbl = sqlTbl + KEY_TBLANDROID + " INTEGER)";
        db.execSQL(sqlTbl);

        String sqlExpdate = "CREATE TABLE " + TABLE_EXPDATE + "(";
        sqlExpdate = sqlExpdate + KEY_INICIODATE + " INTEGER,";
        sqlExpdate = sqlExpdate + KEY_FINDATE + " INTEGER,";
        sqlExpdate = sqlExpdate + KEY_ACTIVE + " INTEGER)";
        db.execSQL(sqlExpdate);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

        String sqlTbl = "DROP TABLE IF EXISTS " + TABLE_BINGOTBL;
        db.execSQL(sqlTbl);

        String sqlExpdate = "DROP TABLE IF EXISTS " + TABLE_EXPDATE;
        db.execSQL(sqlExpdate);

        onCreate(db);

    }

    public void deleteTable (String tabla) {

        SQLiteDatabase db = getWritableDatabase();
        String tablaBorrar = "DELETE FROM " + tabla;

        assert db != null;
        db.execSQL(tablaBorrar);

        db.close();

    }

    public void createBingotbl (Bingotbl bingotbl) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_TBLNRO, bingotbl.Tblnro);
        values.put(KEY_TBLB1, bingotbl.Tblb1);
        values.put(KEY_TBLB2, bingotbl.Tblb2);
        values.put(KEY_TBLB3, bingotbl.Tblb3);
        values.put(KEY_TBLB4, bingotbl.Tblb4);
        values.put(KEY_TBLB5, bingotbl.Tblb5);
        values.put(KEY_TBLI1, bingotbl.Tbli1);
        values.put(KEY_TBLI2, bingotbl.Tbli2);
        values.put(KEY_TBLI3, bingotbl.Tbli3);
        values.put(KEY_TBLI4, bingotbl.Tbli4);
        values.put(KEY_TBLI5, bingotbl.Tbli5);
        values.put(KEY_TBLN1, bingotbl.Tbln1);
        values.put(KEY_TBLN2, bingotbl.Tbln2);
        values.put(KEY_TBLN3, bingotbl.Tbln3);
        values.put(KEY_TBLN4, bingotbl.Tbln4);
        values.put(KEY_TBLN5, bingotbl.Tbln5);
        values.put(KEY_TBLG1, bingotbl.Tblg1);
        values.put(KEY_TBLG2, bingotbl.Tblg2);
        values.put(KEY_TBLG3, bingotbl.Tblg3);
        values.put(KEY_TBLG4, bingotbl.Tblg4);
        values.put(KEY_TBLG5, bingotbl.Tblg5);
        values.put(KEY_TBLO1, bingotbl.Tblo1);
        values.put(KEY_TBLO2, bingotbl.Tblo2);
        values.put(KEY_TBLO3, bingotbl.Tblo3);
        values.put(KEY_TBLO4, bingotbl.Tblo4);
        values.put(KEY_TBLO5, bingotbl.Tblo5);
        values.put(KEY_TBLANDROID, bingotbl.Tblandroid);

        assert db != null;
        db.insert(TABLE_BINGOTBL, null, values);

        db.close();

    }

    public Bingotbl getBingotbl (String Tblnro) {
        SQLiteDatabase db = getReadableDatabase();

        assert db != null;
        Cursor cursor = db.query(TABLE_BINGOTBL,new String[]{
                KEY_TBLNRO,
                KEY_TBLB1,
                KEY_TBLB2,
                KEY_TBLB3,
                KEY_TBLB4,
                KEY_TBLB5,
                KEY_TBLI1,
                KEY_TBLI2,
                KEY_TBLI4,
                KEY_TBLI5,
                KEY_TBLN1,
                KEY_TBLN2,
                KEY_TBLN3,
                KEY_TBLN4,
                KEY_TBLN5,
                KEY_TBLG1,
                KEY_TBLG2,
                KEY_TBLG3,
                KEY_TBLG4,
                KEY_TBLG5,
                KEY_TBLO1,
                KEY_TBLO2,
                KEY_TBLO3,
                KEY_TBLO4,
                KEY_TBLO5,
                KEY_TBLANDROID}, KEY_TBLNRO + " = '?'", new String[] {
                Tblnro
        }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Bingotbl bingotbl = new Bingotbl(cursor);

        db.close();

        return bingotbl;

    }

    public void deleteBingotbl (String tblnro) {

        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_BINGOTBL, KEY_TBLNRO + " = '?'", new String[] {tblnro});

        db.close();

    }


    public List<Bingotbl> getListBingotbl () {

        SQLiteDatabase db = getReadableDatabase();

        List<Bingotbl> tablas = new ArrayList<Bingotbl>();

        assert db != null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_BINGOTBL, null);

        if (cursor.moveToFirst()) {
            do {
                tablas.add(new Bingotbl(cursor));
            }
            while (cursor.moveToNext());
        }

        cursor.close();

        db.close();

        return tablas;

    }

    public int getBingotblCount () {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_BINGOTBL, null);

        int count = cursor.getCount();

        cursor.close();

        db.close();

        return count;

    }

}
