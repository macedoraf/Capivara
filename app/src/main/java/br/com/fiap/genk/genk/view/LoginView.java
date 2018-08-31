package br.com.fiap.genk.genk.view;

import android.content.Context;

import br.com.fiap.genk.genk.model.entity.Usuario;

public interface LoginView {

    Context getContext();

    void loginVaido(Usuario usuario);
}
