package com.example.periodtracker;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/**
 * NotificationAlarmManager manages broadcast events to produce notifications.
 */
public class NotificationAlarmManager extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Alarm has gone off, time to display notification to user
        createNotificationChannel(context);
        displayNotification(context);
    }

    /**
     * Creates a new notification channel for discrete notifications.
     *
     * @param context Application Context
     */
    private void createNotificationChannel(Context context) {
        String channelID = context.getString(R.string.notification_channel_ID);
        String name = context.getString(R.string.notification_channel_name);
        String description = context.getString(R.string.notification_channel_description);
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel channel = new NotificationChannel(channelID, name, importance);
        channel.setDescription(description);

        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    /**
     * Displays a discrete notification to the user.
     *
     * @param context Application Context
     */
    @SuppressLint("MissingPermission") // Suppress, permission check was earlier
    private void displayNotification(Context context) {
        String channelID = context.getString(R.string.notification_channel_ID);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(context.getString(R.string.app_name))
                .setContentTitle(context.getString(R.string.notification_content))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1, notification.build());
    }

}
