package br.com.fiap.genk.genk.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Resposta {

    private String autor;

    private String texto;

    @PrimaryKey(autoGenerate = true)
    private int codigo;

    private int codigoPergunta;

    private int qtdLike;


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQtdLike() {
        return qtdLike;
    }

    public void setQtdLike(int qtdLike) {
        this.qtdLike = qtdLike;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoPergunta() {
        return codigoPergunta;
    }

    public void setCodigoPergunta(int codigoPergunta) {
        this.codigoPergunta = codigoPergunta;
    }
}
