package br.com.fiap.genk.genk.presenter;

import br.com.fiap.genk.genk.model.repository.dao.EncontroDAO;
import br.com.fiap.genk.genk.view.EncontroView;
import br.com.fiap.genk.genk.view.GenkApplication;

public class EncontroPresenterImpl implements EncontroPresenter {

    private EncontroView view;
    private EncontroDAO encontroDAO;

    public EncontroPresenterImpl(EncontroView view) {
        this.view = view;
        this.encontroDAO = GenkApplication.getInstance().getGenkDatabase().encontroDao();

    }

    @Override
    public void carregaDados() {
        view.carregaDados(encontroDAO.selectEncontroByUsuario(GenkApplication.getInstance().getUsuarioLogado().getId()));
    }
}
