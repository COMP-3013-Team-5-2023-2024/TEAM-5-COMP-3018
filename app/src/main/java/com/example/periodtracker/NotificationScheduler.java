package com.example.periodtracker;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.time.LocalDate;

/**
 * NotificationScheduler contains methods to schedule notifications for specific dates.
 */
public class NotificationScheduler {

    /**
     * Schedules a notification for a specific date.
     *
     * @param context Application Context
     * @param date The date the notification is scheduled for.
     */
    public static void scheduleNotification(Context context, LocalDate date) {

        if (context.checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        Intent intent = new Intent(context, NotificationAlarmManager.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        long time = date.toEpochDay();

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
    }

}
