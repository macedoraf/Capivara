package br.com.fiap.genk.genk.view;

import android.content.Context;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Pergunta;

public interface PerguntaView {

    Context getContext();

    void atualizaAdapter();

    List<Pergunta> getListaPergunta();
}
