package com.example.tp1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class baseDonnees extends SQLiteOpenHelper {

    private  final String nomBD="comptes";
    private final String nomTable="tableComptes";
    private  final String colonne="id";
    private final String colonne1="nom";
    private final String colonne2="prenom";
    private final String colonne3="telephone";
    private final String colonne4="mail";
    private final String colonne5="login";
    private final String colonne6="mdp";

    private static final String initBD= "CREATE TABLE tableComptes(id INTEGER PRIMARY KEY, nom TEXT,prenom TEXT, telephone TEXT, mail TEXT, login TEXT, mdp TEXT);";
    private static final String deleteBD="DROP TABLE  IF EXISTS tableComptes;";


    public baseDonnees(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(initBD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL(deleteBD);
        onCreate(db);

    }

    public String[] getCompte(String login){
        String[] retour=new String[2];
        SQLiteDatabase db=this.getReadableDatabase();


        Cursor curseur=db.query("tableComptes", new String[]{"login","mdp"},"login =?",new String[]{login},null,null,null,null);
        curseur.moveToNext();
        retour[0] = curseur.getString(curseur.getColumnIndex("login"));
        retour[1] = curseur.getString(curseur.getColumnIndex("mdp"));

        return retour;

    }

}



