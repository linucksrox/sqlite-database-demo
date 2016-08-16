package com.dalydays.android.sqlitedemo;

/**
 * Created by eric on 8/15/16.
 */
public class CommentDatabaseSchema {
    public final class CommentTable {
        public static final String NAME = "tableName";

        public final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String COMMENT = "comment";
            public static final String DATE = "date";
        }
    }
}
