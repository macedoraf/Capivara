package br.com.fiap.genk.genk.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.view.GenkApplication;
import br.com.fiap.genk.genk.view.fragment.FragmentCadastraAssunto;
import br.com.fiap.genk.genk.view.fragment.FragmentCadastraPergunta;
import br.com.fiap.genk.genk.view.fragment.FragmentEncontro;
import br.com.fiap.genk.genk.view.fragment.FragmentListaAssuntos;
import br.com.fiap.genk.genk.view.fragment.FragmentListaPerguntas;

public class MainActivity extends AppCompatActivity {

    public Toolbar toolbar;

    protected DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaControles();

        configuraToolbar();

        montaViewAssuntos();

        setupNavDrawer();
    }

    private void configuraToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);


    }

    private void inicializaControles() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    public void montaViewAssuntos() {
        FragmentManager fm = this.getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            fm.popBackStack();
        }
        final FragmentTransaction fragmentTransaction = fm.beginTransaction();
        FragmentListaAssuntos fragmentListaAssuntos = new FragmentListaAssuntos();
        fragmentTransaction.replace(R.id.frame, fragmentListaAssuntos);
        fragmentTransaction.commit();
        closeDrawer();
    }

    public void montaViewPergunta(Assunto assunto) {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentListaPerguntas fragmentListaPerguntas = new FragmentListaPerguntas();
        fragmentListaPerguntas.setAssunto(assunto);
        fragmentTransaction.replace(R.id.frame, fragmentListaPerguntas);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        closeDrawer();
    }

    public void montaViewCadastraPergunta() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentCadastraPergunta fragmentCadastraPergunta = new FragmentCadastraPergunta();
        fragmentTransaction.addToBackStack("Pergunta");
        fragmentTransaction.replace(R.id.frame, fragmentCadastraPergunta);
        fragmentTransaction.commit();
        closeDrawer();
    }

    public void motaViewEncontros() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentEncontro fragmentEncontro = new FragmentEncontro();
        fragmentTransaction.addToBackStack("Encontro");
        fragmentTransaction.replace(R.id.frame, fragmentEncontro);
        fragmentTransaction.commit();
        closeDrawer();

    }


    public void montaViewCadastraAssunto() {
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentCadastraAssunto fragmentCadastraAssunto = new FragmentCadastraAssunto();
        fragmentTransaction.addToBackStack("Assunto");
        fragmentTransaction.replace(R.id.frame, fragmentCadastraAssunto);
        fragmentTransaction.commit();
        closeDrawer();

    }

    protected void setupNavDrawer() {
        // Drawer Layout
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Ícone do menu do nav drawer
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

            if (navigationView != null && drawerLayout != null) {
                // Atualiza os dados do header do Navigation View

                // Trata o evento de clique no menu.
                navigationView.setNavigationItemSelectedListener(
                        new NavigationView.OnNavigationItemSelectedListener() {
                            @Override
                            public boolean onNavigationItemSelected(MenuItem menuItem) {
                                // Seleciona a linha
                                menuItem.setChecked(true);
                                // Fecha o menu
                                drawerLayout.closeDrawers();
                                // Trata o evento do menu
                                onNavDrawerItemSelected(menuItem);
                                return true;
                            }
                        });
            }
        }
    }

    private void onNavDrawerItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_assunto:
                montaViewAssuntos();
                closeDrawer();
                break;
            case R.id.menu_encontros:
                montaViewEncontros();
                closeDrawer();
                break;
            case R.id.menu_logout:
                logout();
                break;

        }
    }

    private void logout() {
        startActivity(new Intent(this, LoginActivity.class));
        GenkApplication.getInstance().setUsuarioLogado(null);
        this.finish();
    }

    private void montaViewEncontros() {
        motaViewEncontros();
    }


    protected void openDrawer() {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    // Fecha o menu lateral
    protected void closeDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add)
            montaViewCadastraAssunto();
        else
            openDrawer();


        return super.onOptionsItemSelected(item);
    }


}
