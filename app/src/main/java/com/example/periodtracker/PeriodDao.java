package com.example.periodtracker;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.time.LocalDate;
import java.util.List;

/**
 * Interface for the period database containing methods to interact with it.
 */
@Dao
public interface PeriodDao {

    @Query("SELECT * FROM PeriodRecord")
    List<PeriodRecord> getAll();

    @Insert
    void insertAll(PeriodRecord... periods);

//    @Query("SELECT * FROM PeriodRecord WHERE startDate = :date")
//    public SymptomsRecord findPeriodWithStartDate(LocalDate date);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePeriodRecord(PeriodRecord period);


    @Delete
    void delete(SymptomsRecord symptomsRecord);
}
