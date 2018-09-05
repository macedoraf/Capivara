package br.com.fiap.genk.genk.presenter;

import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.model.entity.Pergunta;

public interface PerguntaPresenter {

    void carregaPerguntas();

    void carregaPerguntas(Assunto assunto);

    void cadastraPergunta(Pergunta pergunta);


}
