package br.com.fiap.genk.genk.view;

import android.content.Context;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Resposta;
import br.com.fiap.genk.genk.model.entity.RespostaLike;

public interface RespostaView {

    Context getContext();

    List<RespostaLike> getRespostaList();

    void atualizaDados();
}
