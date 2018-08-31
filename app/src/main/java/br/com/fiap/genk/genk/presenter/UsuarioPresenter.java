package br.com.fiap.genk.genk.presenter;

import br.com.fiap.genk.genk.model.entity.Usuario;

public interface UsuarioPresenter {

    boolean login(String email, String senha);

    void cadastrarUsuario(Usuario usuario);

    void deletaUsuario(Usuario usuario);
}
