package br.com.fiap.genk.genk.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

@Entity(tableName = "encontro_user_repo",
        primaryKeys = {"userId", "encontroId"},
        foreignKeys = {
                @ForeignKey(entity = Usuario.class,
                        parentColumns = "id", childColumns = "userId"),
                @ForeignKey(entity = Encontro.class,
                        parentColumns = "codigo", childColumns = "encontroId")
        })
public class EncontroUsuario {
    private int userId;
    private int encontroId;

    public EncontroUsuario(int userId, int encontroId) {
        this.userId = userId;
        this.encontroId = encontroId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEncontroId() {
        return encontroId;
    }

    public void setEncontroId(int encontroId) {
        this.encontroId = encontroId;
    }
}
