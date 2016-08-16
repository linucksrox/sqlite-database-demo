package com.dalydays.android.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.dalydays.android.sqlitedemo.CommentDatabaseSchema.CommentTable;

/**
 * Created by eric on 8/15/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "commentDatabase.db";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create database " + CommentTable.NAME + "(" +
                    "_id integer primary key autoincrement, " +
                    CommentTable.Cols.UUID +
                    CommentTable.Cols.TITLE +
                    CommentTable.Cols.COMMENT +
                    CommentTable.Cols.DATE +
                    ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
