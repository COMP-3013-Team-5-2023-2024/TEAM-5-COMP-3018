package com.example.periodtracker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.time.LocalDate;

public class MenstrualCycleTrackerUnitTest {

    @Test
    public void minEndDatePrediction() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        MenstrualCycleTracker.PeriodPrediction prediction = MenstrualCycleTracker.trackMenstrualCycle(startDate);

        LocalDate minDate = LocalDate.of(2023, 1, 3);
        assertEquals(minDate, prediction.minEndDate);
    }

    @Test
    public void maxEndDatePrediction() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        MenstrualCycleTracker.PeriodPrediction prediction = MenstrualCycleTracker.trackMenstrualCycle(startDate);

        LocalDate maxDate = LocalDate.of(2023, 1, 8);
        assertEquals(maxDate, prediction.maxEndDate);
    }

    @Test
    public void ovulationDatePrediction() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        MenstrualCycleTracker.PeriodPrediction prediction = MenstrualCycleTracker.trackMenstrualCycle(startDate);

        LocalDate ovulationDate = LocalDate.of(2023, 1, 15);
        assertEquals(ovulationDate, prediction.ovulation);
    }

    @Test
    public void nextPeriodDatePrediction() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        MenstrualCycleTracker.PeriodPrediction prediction = MenstrualCycleTracker.trackMenstrualCycle(startDate);

        LocalDate nextPeriodDate = LocalDate.of(2023, 1, 29);
        assertEquals(nextPeriodDate, prediction.nextPeriodDate);
    }

}
