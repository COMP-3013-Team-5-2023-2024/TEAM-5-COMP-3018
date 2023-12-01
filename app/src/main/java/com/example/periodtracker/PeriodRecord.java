package com.example.periodtracker;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.time.LocalDate;

/**
 * Represents a period record inside of the period database.
 */
@Entity
public class PeriodRecord {

    @PrimaryKey (autoGenerate = true)
    public int periodID;

    @ColumnInfo
    public LocalDate startDate;

    @ColumnInfo
    public LocalDate endDate;

}
