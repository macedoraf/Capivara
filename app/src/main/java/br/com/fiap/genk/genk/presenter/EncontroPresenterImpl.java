package br.com.fiap.genk.genk.presenter;

import android.os.AsyncTask;

import br.com.fiap.genk.genk.model.entity.Encontro;
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
        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                view.carregaDados(encontroDAO.selectEncontroByUsuario(GenkApplication.getInstance().getUsuarioLogado().getId()));
                return null;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                view.atualizaAdapter();
            }
        }.execute();

    }

    @Override
    public void agendar(int dia, int mes, int ano, int hora, int minuto, double lat, double longe) {

    }

    @Override
    public void inserirEncontro(final Encontro encontro) {
        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                encontroDAO.insert(encontro);
                view.carregaDados(encontroDAO.selectEncontroByUsuario(GenkApplication.getInstance().getUsuarioLogado().getId()));
                return null;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                view.atualizaAdapter();

            }
        }.execute();

    }


}
