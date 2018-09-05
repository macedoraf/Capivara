package br.com.fiap.genk.genk.presenter;

import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.model.entity.Resposta;

public interface RespostaPresenter {

    void insereResposta(Resposta resposta);

    void carregaRespostas(Pergunta pergunta);

}
