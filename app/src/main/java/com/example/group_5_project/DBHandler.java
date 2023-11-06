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

    // below variable is for our table name.
    private static final String USER_TABLE_NAME = "user";

    // below are variables for the user table
    private static final String ID_COL = "id";

    private static final String USERNAME_COL = "username";

    private static final String FIRSTNAME_COL = "firstName";

    private static final String LASTNAME_COL = "lastName";

    private static final String AGE_COL = "age";

    private static final String PIN_COL = "pin";

    private static final String PERIOD_COL = "period";
    private static final String PERIOD_UPDATE_COL = "periodUpdateDate";
    private static final String PERIOD_START_COL ="periodStartDate" ;
    private static final String PERIOD_END_COL = "periodEndDate";
    private static final String BC_COL = "bc";
    private static final String BC_START_COL = "bcStartDate";
    private static final String BC_END_COL = "bcEndDate";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is to initialize the database when it does not exist
    @Override
    public void onCreate(SQLiteDatabase db) {

        String userTableQuery = "CREATE TABLE " + USER_TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME_COL + " TEXT,"
                + FIRSTNAME_COL + " TEXT,"
                + LASTNAME_COL + " TEXT,"
                + PIN_COL + " TEXT,"
                + AGE_COL + " INTEGER,"
                + PERIOD_COL + " INTEGER,"
                + PERIOD_UPDATE_COL + " TEXT,"
                + PERIOD_START_COL + " TEXT,"
                + PERIOD_END_COL + " TEXT,"
                + BC_COL + " INTEGER,"
                + BC_START_COL + " TEXT,"
                + BC_END_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(userTableQuery);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String userName, String firstName, String lastName, String pin, String age) {

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
        userValues.put(FIRSTNAME_COL, firstName);
        userValues.put(LASTNAME_COL, lastName);
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
        onCreate(db);
    }
}

