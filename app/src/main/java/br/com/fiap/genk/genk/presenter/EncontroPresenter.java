package br.com.fiap.genk.genk.presenter;

import br.com.fiap.genk.genk.model.entity.Encontro;

public interface EncontroPresenter {

    void carregaDados();

    void agendar(int dia, int mes, int ano, int hora, int minuto, double lat, double longe);

    void inserirEncontro(Encontro encontro);
}
