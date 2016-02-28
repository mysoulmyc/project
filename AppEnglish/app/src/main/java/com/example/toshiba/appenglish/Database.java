/*
package com.example.toshiba.appenglish;

*/
/*
 * Created by Toshiba on 25/2/2559.
 *//*


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "BTS";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Product";
    public static final String COL_NAME = "name";
    public static final String COL_PIECE_PRICE = "pieceprice";
    public static final String COL_CAKE_PRICE = "cakeprice";

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, " + COL_PIECE_PRICE + " INTEGER, "
                + COL_CAKE_PRICE + " INTEGER);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Chocolate Fudge', 95, 750);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Banana Choc Cake', 55, 500);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Banoffee', 75, 700);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Cheese Cake', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Tiramisu', 85, 800);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}



public class Database {
}
*/
