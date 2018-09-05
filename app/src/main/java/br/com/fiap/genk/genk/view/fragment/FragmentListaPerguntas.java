package br.com.fiap.genk.genk.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.presenter.PerguntaPresenter;
import br.com.fiap.genk.genk.presenter.PerguntaPresenterImpl;
import br.com.fiap.genk.genk.view.PerguntaView;
import br.com.fiap.genk.genk.view.activity.MainActivity;
import br.com.fiap.genk.genk.view.adapter.AdapterPergunta;
import br.com.fiap.genk.genk.view.dialog.DialogResposta;

public class FragmentListaPerguntas extends Fragment implements AdapterPergunta.PerguntaListener, PerguntaView {
    private Assunto assunto;
    private RecyclerView recyclerView;
    private AdapterPergunta adapterPergunta;
    private MainActivity mActivity;
    private List<Pergunta> perguntaList;
    private PerguntaPresenter perguntaPresenter;

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
        perguntaPresenter = new PerguntaPresenterImpl(this);
        perguntaList = new ArrayList<>();

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_lista_pergunta, container, false);
        inicializaControles(view);
        return view;
    }

    private void inicializaControles(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mActivity.toolbar.setTitle("Perguntas");

        mActivity.toolbar.setSubtitle(assunto.getTitulo());

        configuraRecyclerView();

        configuraAdapter();

        carregaDados();

        setHasOptionsMenu(true);


    }

    private void carregaDados() {
        perguntaPresenter.carregaPerguntas(assunto);
    }

    private void configuraAdapter() {
        adapterPergunta = new AdapterPergunta(perguntaList, this);
        recyclerView.setAdapter(adapterPergunta);

    }

    private void configuraRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void onClick(Pergunta pergunta) {

        mostraDialogDeRespostaDaPergunta(pergunta);

    }

    private void mostraDialogDeRespostaDaPergunta(Pergunta pergunta) {
        DialogResposta dialogResposta = new DialogResposta();
        dialogResposta.setPergunta(pergunta);
        dialogResposta.show(getFragmentManager());

    }

    @Override
    public void atualizaAdapter() {
        adapterPergunta.notifyDataSetChanged();
    }

    @Override
    public List<Pergunta> getListaPergunta() {
        return perguntaList;
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_pergunta, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_pergunta) {
            mActivity.montaViewCadastraPergunta();
        }
        return super.onOptionsItemSelected(item);
    }
}
