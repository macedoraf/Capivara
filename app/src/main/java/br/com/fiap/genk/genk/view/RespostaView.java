package br.com.fiap.genk.genk.view;

import android.content.Context;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Resposta;

public interface RespostaView {

    Context getContext();

    List<Resposta> getRespostaList();

    void atualizaDados();
}
