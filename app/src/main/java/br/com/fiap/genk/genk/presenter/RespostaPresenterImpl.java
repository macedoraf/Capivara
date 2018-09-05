package br.com.fiap.genk.genk.presenter;

import android.os.AsyncTask;

import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.model.entity.Resposta;
import br.com.fiap.genk.genk.model.repository.dao.RespostaDAO;
import br.com.fiap.genk.genk.view.GenkApplication;
import br.com.fiap.genk.genk.view.RespostaView;

public class RespostaPresenterImpl implements RespostaPresenter {

    private RespostaView view;

    private RespostaDAO respostaDAO;


    public RespostaPresenterImpl(RespostaView respostaView) {
        view = respostaView;
        respostaDAO = GenkApplication.getInstance().getGenkDatabase().respostaDAO();
    }

    @Override
    public void insereResposta(final Resposta resposta) {

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... voids) {
                respostaDAO.insertResposta(resposta);
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                view.atualizaDados();
            }
        }.execute();


    }

    @Override
    public void carregaRespostas(final Pergunta pergunta) {

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... voids) {
                view.getRespostaList().clear();
                view.getRespostaList().addAll(respostaDAO.getRespostas(pergunta.getId()));
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
            }
        }.execute();


    }
}
