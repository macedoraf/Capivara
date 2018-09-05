package br.com.fiap.genk.genk.presenter;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Assunto;

public interface AssuntoPresenter {


    List<Assunto> getAll();

    void insertAll(Assunto assunto);

    void update(Assunto product);

    void delete(Assunto product);

    void getUnique();
}
