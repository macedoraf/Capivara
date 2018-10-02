package br.com.fiap.genk.genk.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Usuario;
import br.com.fiap.genk.genk.presenter.UsuarioPresenter;
import br.com.fiap.genk.genk.presenter.UsuarioPresenterImpl;
import br.com.fiap.genk.genk.view.GenkApplication;
import br.com.fiap.genk.genk.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText edtEmail;

    private EditText edtSenha;

    private Button btnLogin;

    private Button btnCadastrar;

    private Intent intent;

    private UsuarioPresenter presenter;

    private View.OnClickListener actionCadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            redirecionaCadastro();
        }
    };

    private void redirecionaCadastro() {
        intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }

    private void redirecionaLogin(Usuario usuario) {
        GenkApplication.getInstance().setUsuarioLogado(usuario);
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    private View.OnClickListener actionLogin = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tentaLogin();


        }
    };

    private void tentaLogin() {
        presenter.login(edtEmail.getText().toString(), edtSenha.getText().toString());
    }

    public void loginVaido(Usuario usuario) {

        if (usuario != null)
            redirecionaLogin(usuario);
        else
            Toast.makeText(LoginActivity.this, "Usuario ou senha inválidos!", Toast.LENGTH_LONG).show();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new UsuarioPresenterImpl(this);
        inicializaControles();
        configuraListeners();
    }

    private void configuraListeners() {
        btnCadastrar.setOnClickListener(actionCadastrar);
        btnLogin.setOnClickListener(actionLogin);

    }


    private void inicializaControles() {
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);

    }


    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }
}
