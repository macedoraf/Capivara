package br.com.fiap.genk.genk.model.entity;

import java.util.List;

public class RespostaLike {
    private Resposta resposta;
    private List<Laike> like;

    public RespostaLike(Resposta resposta, List<Laike> like) {
        this.resposta = resposta;
        this.like = like;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public List<Laike> getLike() {
        return like;
    }

    public void setLike(List<Laike> like) {
        this.like = like;
    }
}
