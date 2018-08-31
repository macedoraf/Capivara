package br.com.fiap.genk.genk.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.view.fragment.FragmentListaAssuntos;

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

    }

    private void inicializaControles() {
        toolbar = findViewById(R.id.toolbar);

    }


    public void montaViewAssuntos() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentListaAssuntos fragmentListaAssuntos = new FragmentListaAssuntos();
        fragmentTransaction.replace(R.id.frame, fragmentListaAssuntos);
        fragmentTransaction.commit();
    }

    public void montaViewPergunta() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentListaAssuntos fragmentListaAssuntos = new FragmentListaAssuntos();
        fragmentTransaction.replace(R.id.frame, fragmentListaAssuntos);
        fragmentTransaction.commit();
    }

    public void montaViewCadastraPergunta() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentListaAssuntos fragmentListaAssuntos = new FragmentListaAssuntos();
        fragmentTransaction.replace(R.id.frame, fragmentListaAssuntos);
        fragmentTransaction.commit();
    }
}
