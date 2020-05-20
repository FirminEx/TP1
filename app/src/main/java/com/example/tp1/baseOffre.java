package com.example.tp1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class baseOffre extends SQLiteOpenHelper {

    private static final String BD="CREATE TABLE tableOffres(id INTERGER PRIMARY KEY,nom TEXT,prenom TEXT,modele TEXT,couleur TEXT,plaque TEXT,lieurdv TEXT, destination TEXT, heure TEXT, places INTEGER);";
    private static final String deleteBD="DROP TABLE  IF EXISTS tableOffres;";

    public baseOffre(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(deleteBD);
        this.onCreate(db);
    }
}
