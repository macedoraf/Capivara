package br.com.fiap.genk.genk.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Usuario;
import br.com.fiap.genk.genk.presenter.UsuarioPresenter;
import br.com.fiap.genk.genk.presenter.UsuarioPresenterImpl;
import br.com.fiap.genk.genk.view.LoginView;

public class CadastroActivity extends AppCompatActivity implements LoginView {

    private EditText edtEmail;
    private EditText edtSenha;
    private EditText edtNome;
    private Button btnSalvar;
    private UsuarioPresenter presenter;

    private View.OnClickListener actionSalvarUsuario = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            salvarCadastro();
        }
    };

    private void salvarCadastro() {
        Usuario usuario = new Usuario(edtNome.getText().toString(), edtEmail.getText().toString(), edtSenha.getText().toString());
        presenter = new UsuarioPresenterImpl(this);
        presenter.cadastrarUsuario(usuario);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializaControles();
        configuraListeners();
    }

    private void configuraListeners() {
        btnSalvar.setOnClickListener(actionSalvarUsuario);

    }

    private void inicializaControles() {

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnSalvar = findViewById(R.id.btnSalvar);
        edtNome = findViewById(R.id.edtNome);

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void loginVaido(Usuario usuario) {
        this.finish();

    }
}
