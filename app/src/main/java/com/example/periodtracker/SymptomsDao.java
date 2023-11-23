package com.example.periodtracker;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.time.LocalDate;
import java.util.List;

@Dao
public interface SymptomsDao {

    @Query("SELECT * FROM SymptomsRecord")
    List<SymptomsRecord> getAll();

    @Insert
    void insertAll (SymptomsRecord... symptoms);

    @Query("SELECT * FROM SymptomsRecord WHERE date = :date")
    public SymptomsRecord findSymptomWithDate(LocalDate date);

    @Delete
    void delete(SymptomsRecord symptomsRecord);
}
