package com.example.group_5_project;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "periodDB.db";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variables are for our table names.

    private static final String PERIOD_TABLE_NAME = "period";


    // below are column names for the table
    private static final String PERIOD_COL = "period";
    private static final String PERIOD_UPDATE_COL = "periodUpdateDate";
    private static final String PERIOD_START_COL ="periodStartDate" ;
    private static final String PERIOD_END_COL = "periodEndDate";
    private static final String BC_COL = "bc";
    private static final String BC_START_COL = "bcStartDate";
    private static final String BC_END_COL = "bcEndDate";

    private static final String PERIOD_ID_COL = "periodId";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is to initialize the database when it does not exist
    @Override
    public void onCreate(SQLiteDatabase db) {
        String periodTableQuery = "CREATE TABLE " + PERIOD_TABLE_NAME + " ("
                + PERIOD_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PERIOD_COL + " INTEGER,"
                + PERIOD_UPDATE_COL + " TEXT,"
                + PERIOD_START_COL + " TEXT,"
                + PERIOD_END_COL + " TEXT,"
                + BC_COL + " INTEGER,"
                + BC_START_COL + " TEXT,"
                + BC_END_COL + " TEXT)";
        // at last we are calling a exec sql
        db.execSQL(periodTableQuery);
    }

    // this method is use to add new course to our sqlite database.
    public void addFirstPeriod() {
//         on below line we are creating a variable for
//         our sqlite database and calling writable method
//         as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

//         on below line we are creating a
//         variable for content values.
        ContentValues periodValues = new ContentValues();

//         on below line we are passing all values
//         along with its key and value pair.
        periodValues.put(PERIOD_COL, 0);

//         after adding all values we are passing
//         content values to our table.
        db.insert(PERIOD_TABLE_NAME, null, periodValues);
//        used to close db,but commented it so we read the database from the inspector
//        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PERIOD_TABLE_NAME);
        onCreate(db);
    }
}

