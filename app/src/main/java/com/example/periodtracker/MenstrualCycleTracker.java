package com.example.periodtracker;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

public class MenstrualCycleTracker {

    public static class PeriodPrediction {
        public LocalDate startDate;
        public LocalDate minEndDate;
        public LocalDate maxEndDate;

        public PeriodPrediction() {
        }
    }

    public static PeriodPrediction trackMenstrualCycle(LocalDate inputDate) {

        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date startDate = Date.from(inputDate.atStartOfDay(defaultZoneId).toInstant());

        // Predicted Period
        PeriodPrediction predictedPeriod = new PeriodPrediction();

        // Calculate the expected ovulation date (typically around the 14th day of the cycle)
        Calendar ovulationDate = Calendar.getInstance();
        ovulationDate.setTime(startDate);
        ovulationDate.add(Calendar.DAY_OF_MONTH, 14);

        // Calculate the next menstrual cycle start date (typically around the 28th day of the cycle)
        Calendar nextCycleDate = Calendar.getInstance();
        nextCycleDate.setTime(startDate);
        nextCycleDate.add(Calendar.DAY_OF_MONTH, 28);

        // Calculates the predicted end date of the period (typically between 2nd and 7th day of the cycle)
        Calendar endDateMin = Calendar.getInstance();
        Calendar endDateMax = Calendar.getInstance();
        endDateMin.setTime(startDate);
        endDateMax.setTime(startDate);
        endDateMin.add(Calendar.DAY_OF_MONTH, 2);
        endDateMax.add(Calendar.DAY_OF_MONTH, 7);

        predictedPeriod.startDate = inputDate;
        predictedPeriod.minEndDate = LocalDate.of(endDateMin.get(Calendar.YEAR),
                endDateMin.get(Calendar.MONTH) + 1, // Months in Calendar start from 0
                endDateMin.get(Calendar.DAY_OF_MONTH)) ;
        predictedPeriod.maxEndDate = LocalDate.of(endDateMax.get(Calendar.YEAR),
                endDateMax.get(Calendar.MONTH) + 1, // Months in Calendar start from 0
                endDateMax.get(Calendar.DAY_OF_MONTH)) ;

        return predictedPeriod;
    }

}
