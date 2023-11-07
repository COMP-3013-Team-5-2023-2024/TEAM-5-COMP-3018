package com.example.group_5_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "periodDB.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variables are for our table names.
    private static final String USER_TABLE_NAME = "user";
    private static final String PERIOD_HIST_TABLE_NAME = "periodHistory";

    // below are column names for the tables
    private static final String USERID_COL = "userId";

    private static final String USERNAME_COL = "username";
    private static final String AGE_COL = "age";

    private static final String PIN_COL = "pin";

    private static final String PERIOD_COL = "period";
    private static final String PERIOD_UPDATE_COL = "periodUpdateDate";
    private static final String PERIOD_START_COL ="periodStartDate" ;
    private static final String PERIOD_END_COL = "periodEndDate";
    private static final String BC_COL = "bc";
    private static final String BC_START_COL = "bcStartDate";
    private static final String BC_END_COL = "bcEndDate";

    private static final String PERIOD_HIST_ID_COL = "historyId";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is to initialize the database when it does not exist
    @Override
    public void onCreate(SQLiteDatabase db) {

        String userTableQuery = "CREATE TABLE " + USER_TABLE_NAME + " ("
                + USERID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME_COL + " TEXT,"
                + PIN_COL + " TEXT,"
                + AGE_COL + " INTEGER,"
                + PERIOD_COL + " INTEGER,"
                + PERIOD_UPDATE_COL + " TEXT,"
                + PERIOD_START_COL + " TEXT,"
                + PERIOD_END_COL + " TEXT,"
                + BC_COL + " INTEGER,"
                + BC_START_COL + " TEXT,"
                + BC_END_COL + " TEXT)";

        String periodHistoryTableQuery = "CREATE TABLE " + PERIOD_HIST_TABLE_NAME + " ("
                + USERID_COL + " INTEGER,"
                + PERIOD_HIST_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PERIOD_START_COL + " TEXT,"
                + PERIOD_END_COL + " TEXT,"
                + " FOREIGN KEY(" + USERID_COL + ") REFERENCES " + USER_TABLE_NAME + "(" + USERID_COL + "))";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(userTableQuery);
        db.execSQL(periodHistoryTableQuery);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String userName, String pin, String age) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues userValues = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.

        userValues.put(USERNAME_COL, userName);
        userValues.put(AGE_COL, Integer.valueOf(age));
        userValues.put(PIN_COL, pin);


        // after adding all values we are passing
        // content values to our table.
        db.insert(USER_TABLE_NAME, null, userValues);
//        used to close db,but commented it so we read the database from the inspector
//        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PERIOD_HIST_TABLE_NAME);
        onCreate(db);
    }
}

