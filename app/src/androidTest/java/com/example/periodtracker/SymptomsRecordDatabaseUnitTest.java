package com.example.periodtracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RunWith(JUnit4.class)
public class SymptomsDatabaseUnitTest {
        private SymptomsDao symptomsDao;
        private AppDatabase db;

        @Before
        public void createDb() {
            Context context = ApplicationProvider.getApplicationContext();
            db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
            symptomsDao = db.symptomsDAO();
        }

        @After
        public void closeDb() throws IOException {
            db.close();
        }

        @Test
        public void addNewSymptom() {
            Symptoms symptom = new Symptoms();
            symptom.symptoms = 1;
            symptom.mood = 1;
            symptom.date = LocalDate.now();
            symptomsDao.insertAll(symptom);
            List<Symptoms> symptoms = symptomsDao.getAll();
            assertEquals(1, symptoms.size());
        }

        @Test
        public void getSymptom() {
            // Repeat code, JUnit can run in arbitrary order
            Symptoms symptom = new Symptoms();
            symptom.symptoms = 1;
            symptom.mood = 1;
            symptom.date = LocalDate.now();
            symptomsDao.insertAll(symptom);

            LocalDate date = LocalDate.now();
            symptom = symptomsDao.findSymptomWithDate(date);
            System.out.println(symptom.mood);
            assertNotEquals(null, symptom);
        }

}
