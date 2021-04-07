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

    public Cursor fetch()
    {
        String[] columns = new String[] {DatabaseHelper._ID,
                DatabaseHelper.TITRE, DatabaseHelper.DESC};

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns,
                selection(null),
                selectionArgs(null),
                groupBy(null),
                having(null),
                orderBy(null)
        );

        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }


    private int update(long _id, String name, String desc)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.DESC, desc);

        int i = database.update(DatabaseHelper.TABLE_NAME,
                contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }


    public void delete(long _id)
    {
        database.delete(DatabaseHelper.TABLE_NAME,
                DatabaseHelper._ID + " = " + _id, null);
    }
}
