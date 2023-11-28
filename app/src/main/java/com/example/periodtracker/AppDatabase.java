package com.example.periodtracker;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * Abstract class representing an implementation to access the applications database.
 */
@Database(entities = {SymptomsRecord.class, PeriodRecord.class}, version = 1)
@TypeConverters({SymptomsRecord.Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract SymptomsDao symptomsDAO();

    public abstract PeriodDao periodDao();

}
