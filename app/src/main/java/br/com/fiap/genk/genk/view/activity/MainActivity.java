package br.com.fiap.genk.genk.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.view.fragment.FragmentListaAssuntos;
import br.com.fiap.genk.genk.view.fragment.FragmentListaPerguntas;

public class MainActivity extends AppCompatActivity {

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaControles();

        configuraToolbar();

        montaViewAssuntos();
    }

    private void configuraToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    private void inicializaControles() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    public void montaViewAssuntos() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentListaAssuntos fragmentListaAssuntos = new FragmentListaAssuntos();
        fragmentTransaction.replace(R.id.frame, fragmentListaAssuntos);
        fragmentTransaction.commit();
    }

    public void montaViewPergunta(Assunto assunto) {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentListaPerguntas fragmentListaPerguntas = new FragmentListaPerguntas();
        fragmentListaPerguntas.setAssunto(assunto);
        fragmentTransaction.replace(R.id.frame, fragmentListaPerguntas);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void montaViewCadastraPergunta() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentListaAssuntos fragmentListaAssuntos = new FragmentListaAssuntos();
        fragmentTransaction.replace(R.id.frame, fragmentListaAssuntos);
        fragmentTransaction.commit();
    }
}
