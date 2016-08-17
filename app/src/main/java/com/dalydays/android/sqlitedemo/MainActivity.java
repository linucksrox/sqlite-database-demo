package com.dalydays.android.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dalydays.android.sqlitedemo.CommentDatabaseSchema.CommentTable;

import org.w3c.dom.Comment;

import java.util.Date;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText commentEditText;
    private SQLiteDatabase db;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the EditTexts and Button
        titleEditText = (EditText) findViewById(R.id.title_edit_text);
        commentEditText = (EditText) findViewById(R.id.comment_edit_text);
        addButton = (Button) findViewById(R.id.add_button);

        // set onClickListener for the add button
        View.OnClickListener addButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the database for read/write
                db = new DatabaseHelper(MainActivity.this).getWritableDatabase();
                db.insert(CommentTable.NAME, null, getContentValues());
                db.close();
                commentEditText.setText("");
                titleEditText.setText("");
                titleEditText.requestFocus();
                Toast.makeText(getApplicationContext(), "Added to database", Toast.LENGTH_SHORT).show();
            }
        };
        addButton.setOnClickListener(addButtonListener);
    }

    private ContentValues getContentValues() {
        ContentValues values = new ContentValues();

        values.put(CommentTable.Cols.UUID, UUID.randomUUID().toString());
        values.put(CommentTable.Cols.TITLE, titleEditText.getText().toString());
        values.put(CommentTable.Cols.COMMENT, commentEditText.getText().toString());
        values.put(CommentTable.Cols.DATE, new Date().toString());

        return values;
    }
}
