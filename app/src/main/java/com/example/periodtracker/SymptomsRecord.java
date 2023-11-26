package com.example.periodtracker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import java.time.LocalDate;

/**
 * SymptomsRecord is an object that represents a symptoms record within the database.
 */
@Entity
public class SymptomsRecord {

    @PrimaryKey (autoGenerate = true)
    public int symptomsID;

    @ColumnInfo
    public LocalDate date;

    @ColumnInfo
    public String mood;

    @ColumnInfo
    public String symptoms;

    /**
     * Converts date attribute between Long and LocalDate object.
     */
    public static class Converters {
        @TypeConverter
        public static LocalDate fromTimestamp(Long value) {
            return value == null ? null : LocalDate.ofEpochDay(value);
        }

        @TypeConverter
        public static Long dateToTimestamp(LocalDate date) {
            return date == null ? null : date.toEpochDay();
        }
    }

}
