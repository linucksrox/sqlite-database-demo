package com.dalydays.android.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import com.dalydays.android.sqlitedemo.CommentDatabaseSchema.CommentTable;

public class MainActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText commentEditText;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the EditTexts
        titleEditText = (EditText) findViewById(R.id.title_edit_text);
        commentEditText = (EditText) findViewById(R.id.comment_edit_text);

        // Open the database for read/write
        db = new DatabaseHelper(this).getWritableDatabase();
    }

    public static void addCommentButtonClick(Context context) {
        // Add the comment to the database, update the list of comments,
        // and clear the existing EditTexts
    }

    private ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(CommentTable.Cols.UUID, )
        values.put(CommentTable.Cols.TITLE, titleEditText.getText().toString());
        values.put(CommentTable.Cols.COMMENT, commentEditText.getText().toString());
    }

    @Override
    protected void onPause() {
        super.onPause();

        db.close();
    }
}
