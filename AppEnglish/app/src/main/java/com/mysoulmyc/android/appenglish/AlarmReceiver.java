package com.mysoulmyc.android.appenglish;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Toshiba on 21/4/2559.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Calendar now = GregorianCalendar.getInstance();
        //int dayOfWeek = now.get(Calendar.DATE);
        //if (dayOfWeek != 1 && dayOfWeek != 7) {
        //if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {

            Intent notificationIntent = new Intent(context, StartActivity.class);

            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(StartActivity.class);
            stackBuilder.addNextIntent(notificationIntent);

            PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

            Notification notification = builder.setContentTitle("EngApp Notification")
                    .setContentText("We miss you!")
                    .setTicker("New Message Alert!")
                    .setAutoCancel(true)
                    //.setOngoing(true)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pendingIntent).build();

            notification.defaults |= Notification.DEFAULT_VIBRATE;
            //notification.flags |= Notification.FLAG_ONGOING_EVENT;
            notification.flags |= Notification.FLAG_SHOW_LIGHTS;
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            //notification.flags |= Notification.FLAG_NO_CLEAR;

            builder.setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notification);
            //builder.setProgress(0, 0, true);

            Log.d("Notification", " : Notification sent!");
            //}
       //}
    }
}
