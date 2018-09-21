package br.com.fiap.genk.genk.presenter;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.model.entity.Resposta;
import br.com.fiap.genk.genk.model.entity.RespostaLike;
import br.com.fiap.genk.genk.model.repository.dao.LikeDAO;
import br.com.fiap.genk.genk.model.repository.dao.RespostaDAO;
import br.com.fiap.genk.genk.view.GenkApplication;
import br.com.fiap.genk.genk.view.RespostaView;

public class RespostaPresenterImpl implements RespostaPresenter {

    private RespostaView view;

    private RespostaDAO respostaDAO;

    private LikeDAO likeDAO;


    public RespostaPresenterImpl(RespostaView respostaView) {
        view = respostaView;
        respostaDAO = GenkApplication.getInstance().getGenkDatabase().respostaDAO();
        likeDAO = GenkApplication.getInstance().getGenkDatabase().likeDao();
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
                view.getRespostaList().addAll(getRespostasComLike(pergunta.getId()));
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
            }
        }.execute();


    }

    public List<RespostaLike> getRespostasComLike(int idPergunta) {
        final List<Resposta> respostas = respostaDAO.getRespostas(idPergunta);
        final List<RespostaLike> respostaLikes = new ArrayList<>();

        for (Resposta resposta : respostas) {
            respostaLikes.add(new RespostaLike(resposta, likeDAO.getLikesByResposta(resposta.getCodigo())));

        }

        return respostaLikes;
    }

}
