package br.com.fiap.genk.genk.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Assunto {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String titulo;

    private int cor;

    @Ignore
    public Assunto(int id, String titulo, int cor) {
        this.id = id;
        this.titulo = titulo;
        this.cor = cor;
    }

    @Ignore
    public Assunto(String titulo, int cor) {
        this.titulo = titulo;
        this.cor = cor;
    }

    @Ignore
    public Assunto(String titulo) {
        this.titulo = titulo;
    }

    public Assunto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
}
