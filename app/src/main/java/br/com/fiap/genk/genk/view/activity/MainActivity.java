package br.com.fiap.genk.genk.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.view.fragment.FragmentListaAssuntos;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        montaViewAssuntos();
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
