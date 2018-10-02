package br.com.fiap.genk.genk.view;

import android.content.Context;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Encontro;

public interface EncontroView {

    void showLoading();

    void hideLoading();

    void atualizaAdapter();

    void carregaDados(List<Encontro> encontroList);

    Context getContext();


}
