package br.com.fiap.genk.genk.utill;

import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import br.com.fiap.genk.genk.R;

public class NotificationHelper {


    public static void makeNotification(Context context, String endereco, PendingIntent pendingIntent) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                    .setContentTitle("Você tem um encontro hoje")
                    .setContentText(endereco)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
            notificationManager.notify(0, mBuilder.build());

        }
    }
}
