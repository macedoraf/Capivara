package br.com.fiap.genk.genk.utill;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class NotificationBuilder {


    public static void makeNotification(Context context, String endereco, PendingIntent pendingIntent) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            Notification builder = new Notification.Builder(context)
                    .setContentTitle("Você tem um encontro amanhã")
                    .setContentText(endereco)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build();

        }
    }
}
