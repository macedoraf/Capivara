package br.com.fiap.genk.genk.view;

import android.content.Context;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Assunto;

public interface AssuntoView {

    Context getContext();

    void atualizaLista(List<Assunto> assuntoList);






}
