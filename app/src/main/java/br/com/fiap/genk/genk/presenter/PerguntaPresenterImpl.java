package br.com.fiap.genk.genk.presenter;

import android.os.AsyncTask;

import br.com.fiap.genk.genk.model.repository.dao.PerguntaDAO;
import br.com.fiap.genk.genk.view.GenkApplication;
import br.com.fiap.genk.genk.view.PerguntaView;

public class PerguntaPresenterImpl implements PerguntaPresenter {

    private final PerguntaView perguntaView;
    private final PerguntaDAO perguntaDAO;

    public PerguntaPresenterImpl(PerguntaView perguntaView) {
        this.perguntaView = perguntaView;
        this.perguntaDAO = GenkApplication.getInstance().getGenkDatabase().perguntaDAO();
    }

    @Override
    public void carregaPerguntas() {

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... voids) {
                perguntaView.getListaPergunta().clear();
                perguntaView.getListaPergunta().addAll(perguntaDAO.getAll());
                return true;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                perguntaView.atualizaAdapter();
            }
        }.execute();

    }


}
