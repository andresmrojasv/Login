package com.example.estacion.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ESTACION on 30/06/2017.
 */

public class UsuariosDB extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE usuarios (user TEXT PRIMARY KEY, pass TEXT)";

    public UsuariosDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL(sqlCreate);

    }
}
