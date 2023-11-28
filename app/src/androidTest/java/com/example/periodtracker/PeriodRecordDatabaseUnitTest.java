package com.example.periodtracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class PeriodRecordDatabaseUnitTest {

    private PeriodDao periodDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        periodDao = db.periodDao();
    }

    @Test
    public void addNewPeriod() {
        PeriodRecord record = new PeriodRecord();
        record.startDate = LocalDate.now();
        record.endDate = LocalDate.now();
        periodDao.insertAll(record);
        List<PeriodRecord> symptoms = periodDao.getAll();
        assertEquals(1, symptoms.size());
    }

    @Test
    public void getPeriod() {
        PeriodRecord record = new PeriodRecord();
        record.startDate = LocalDate.now();
        record.endDate = LocalDate.now();
        periodDao.insertAll(record);

        LocalDate date = LocalDate.now();
        record = periodDao.findPeriodWithStartDate(date);
        assertNotEquals(null, record);
    }

}
