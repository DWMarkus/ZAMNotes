package com.example.zamnotes;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Nom de la Table :
    public static final String TABLE_NAME = "NOTES";

    // Colonnes :
    public static final String _ID = "_id";
    public static final String TITRE = "titre";
    public static final String DESC = "description";

    // BDD :
    static final String DB_NAME = "ZAM_APP.DB";

    // DB Version :
    static final int DB_VERSION = 1;

    // Création de la Table :
    private static final String CREATE_TABLE = "create table" + TABLE_NAME + "(" + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITRE + " TEXT NOT NULL, " + DESC + " TEXT);";

    public DatabaseHelper(Context context)
    {
        super(context, DB_NAME, factory(null), DB_VERSION);
    }

    public void OnCreate(SQLiteDatabase db)
    {
        // Execute la requete
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
