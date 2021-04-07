package com.example.zamnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DBManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;


    /// Construteur
    public DBManager(Context c)
    {
        context = c;
    }

    public DBManager open() throws SQLiteException
    {
        dbHelper = new DatabaseHelper(contenu);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        dbHelper.close();
    }

    // Méthodes de DBManager
    public void insert(String titre, String desc)
    {
        ContentValues contentValues = new ContextValues();
        contentValues.put(DatabaseHelper.TITRE, titre);
        contentValues.put(DatabaseHelper.DESC, desc);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}
