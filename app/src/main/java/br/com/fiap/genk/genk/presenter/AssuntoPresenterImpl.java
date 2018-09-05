package br.com.fiap.genk.genk.presenter;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.model.repository.dao.AssuntoDAO;
import br.com.fiap.genk.genk.view.AssuntoView;
import br.com.fiap.genk.genk.view.GenkApplication;

public class AssuntoPresenterImpl implements AssuntoPresenter {

    private final AssuntoView assuntoView;
    private final AssuntoDAO assuntoDAO;

    public AssuntoPresenterImpl(AssuntoView assuntoView) {
        this.assuntoView = assuntoView;
        this.assuntoDAO = GenkApplication.getInstance().getGenkDatabase().assuntoDAO();

    }


    @Override
    public List<Assunto> getAll() {

        new AsyncTask<Void, Void, List<Assunto>>() {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected List<Assunto> doInBackground(Void... voids) {
                return assuntoDAO.getAll();
            }

            @Override
            protected void onPostExecute(List<Assunto> assuntoList) {
                super.onPostExecute(assuntoList);
                assuntoView.atualizaLista(assuntoList);
            }
        }.execute();

        return null;
    }

    @Override
    public void insertAll(final Assunto assunto) {

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... voids) {
                assuntoDAO.insert(assunto);
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                assuntoView.atualizaLista(null);


            }
        }.execute();

    }

    @Override
    public void update(Assunto product) {

    }

    @Override
    public void delete(final Assunto assunto) {

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... voids) {
                assuntoDAO.delete(assunto);
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);


            }
        }.execute();

    }

    @Override
    public void getUnique() {
        new AsyncTask<Void, Void, Boolean>() {
            List<Assunto> assuntoList = new ArrayList<>();

            @Override
            protected Boolean doInBackground(Void... voids) {
                assuntoList.addAll(assuntoDAO.getAll());
                assuntoView.atualizaLista(assuntoList);
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);


            }
        }.execute();
    }
}
