package com.example.periodtracker;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {SymptomsRecord.class}, version = 1)
@TypeConverters({SymptomsRecord.Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract SymptomsDao symptomsDAO();

}
