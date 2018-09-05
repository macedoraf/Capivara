package br.com.fiap.genk.genk.view;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import br.com.fiap.genk.genk.model.entity.Usuario;
import br.com.fiap.genk.genk.model.repository.GenkDatabase;

public class GenkApplication extends Application {

    private GenkDatabase genkDatabase;
    private Usuario usuarioLogado;
    private static GenkApplication instace;

    @Override
    public void onCreate() {
        super.onCreate();
        instace = this;
        genkDatabase = Room.databaseBuilder(this, GenkDatabase.class, "Genk_db").fallbackToDestructiveMigration().build();
    }


    public static GenkApplication getInstance() {
        return instace;
    }


    public GenkDatabase getGenkDatabase() {
        return genkDatabase;
    }


    public void setUsuarioLogado(Usuario s) {
        usuarioLogado = s;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
