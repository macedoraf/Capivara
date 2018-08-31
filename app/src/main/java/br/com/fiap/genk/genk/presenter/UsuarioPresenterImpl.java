package br.com.fiap.genk.genk.presenter;

import android.os.AsyncTask;

import br.com.fiap.genk.genk.model.entity.Usuario;
import br.com.fiap.genk.genk.model.repository.dao.UsuarioDAO;
import br.com.fiap.genk.genk.view.GenkApplication;
import br.com.fiap.genk.genk.view.LoginView;

public class UsuarioPresenterImpl implements UsuarioPresenter {

    private final LoginView loginView;
    final UsuarioDAO usuarioDAO;

    public UsuarioPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        usuarioDAO = GenkApplication.getInstance().getGenkDatabase().usuarioDAO();
    }


    @Override
    public boolean login(final String email, final String senha) {

        new AsyncTask<Void, Void, Usuario>() {
            @Override
            protected Usuario doInBackground(Void... voids) {

                return usuarioDAO.getUsuario(email, senha);
            }

            @Override
            protected void onPostExecute(Usuario usuario) {
                super.onPostExecute(usuario);

                loginView.loginVaido(usuario);
            }
        }.execute();

        return true;
    }

    @Override
    public void cadastrarUsuario(final Usuario usuario) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                GenkApplication.getInstance().getGenkDatabase().usuarioDAO().insertUsuario(usuario);
                loginView.loginVaido(null);

            }
        }).start();

    }

    @Override
    public void deletaUsuario(Usuario usuario) {


        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }
}
