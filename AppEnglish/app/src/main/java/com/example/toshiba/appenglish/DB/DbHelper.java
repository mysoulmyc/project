package com.example.toshiba.appenglish.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/*
 * Created by Toshiba on 27/2/2559.
 */
public class DbHelper extends SQLiteAssetHelper {
    private static final int DATABASE_VERSION = 37;
    private static final String DATABASE_NAME = "db.sqlite";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //this.myContext=context;
        setForcedUpgrade(DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + db);
        // Create tables again
        onCreate(db);
    }

}
