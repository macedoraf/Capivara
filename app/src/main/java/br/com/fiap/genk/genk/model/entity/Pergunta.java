package br.com.fiap.genk.genk.model.entity;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Pergunta {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String titulo;

    private String topico;

    private String descricao;

    private String resposta;

    private String autor;

    private int like;

    public int getLike() {
        return like;
    }

    public Pergunta() {
    }

    @Ignore
    public Pergunta(String titulo, String topico, String descricao, String resposta, String autor) {
        this.titulo = titulo;
        this.topico = topico;
        this.descricao = descricao;
        this.resposta = resposta;
        this.autor = autor;
    }
    @Ignore
    public Pergunta(int id, String titulo, String topico, String descricao, String resposta, String autor, int like) {
        this.id = id;
        this.titulo = titulo;
        this.topico = topico;
        this.descricao = descricao;
        this.resposta = resposta;
        this.autor = autor;
        this.like = like;
    }



    public int isLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
