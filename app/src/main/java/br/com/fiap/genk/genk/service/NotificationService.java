package br.com.fiap.genk.genk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import br.com.fiap.genk.genk.utill.NotificationHelper;

public class NotificationService extends Service {

    private String mensagem = "Mensagem padrão";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if (intent != null)
            mensagem = intent.getStringExtra("mensagem");
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        NotificationHelper.makeNotification(this, mensagem, null);

    }
}
