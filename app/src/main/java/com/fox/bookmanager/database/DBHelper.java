package com.fox.bookmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import com.fox.bookmanager.Constants;

import static com.fox.bookmanager.Constants.BOOK_TABLE;
import static com.fox.bookmanager.Constants.CATEGORY_TABLE;
import static com.fox.bookmanager.Constants.CREATE_BOOK_TABLE;
import static com.fox.bookmanager.Constants.CREATE_CATEGORY_TABLE;
import static com.fox.bookmanager.Constants.CREATE_INVOICE_DETAIL_TABLE;
import static com.fox.bookmanager.Constants.CREATE_INVOICE_TABLE;
import static com.fox.bookmanager.Constants.CREATE_USER_TABLE;
import static com.fox.bookmanager.Constants.INVOICE_DETAIL_TABLE;
import static com.fox.bookmanager.Constants.INVOICE_TABLE;
import static com.fox.bookmanager.Constants.USER_TABLE;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "book_manager.sql", null, 1);
        if(Constants.isDEBUG) Log.i("CREATE_USER_TABLE",CREATE_USER_TABLE);
        if(Constants.isDEBUG) Log.i("CREATE_INVOICE_TABLE",CREATE_INVOICE_TABLE);
        if(Constants.isDEBUG) Log.i("CREATE_BOOK_TABLE",CREATE_BOOK_TABLE);
        if(Constants.isDEBUG) Log.i("CREATE_CATEGORY_TABLE",CREATE_CATEGORY_TABLE);
        if(Constants.isDEBUG) Log.i("CREATE_IN_DETAIL_TABLE",CREATE_INVOICE_DETAIL_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_INVOICE_TABLE);
        db.execSQL(CREATE_BOOK_TABLE);
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_INVOICE_DETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + INVOICE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BOOK_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + INVOICE_DETAIL_TABLE);
    }
}
