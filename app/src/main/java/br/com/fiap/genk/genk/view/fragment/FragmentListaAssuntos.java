package br.com.fiap.genk.genk.view.fragment;

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
import br.com.fiap.genk.genk.view.activity.MainActivity;
import br.com.fiap.genk.genk.view.adapter.AdapterAssunto;

public class FragmentListaAssuntos extends Fragment implements AdapterAssunto.AssuntoListener {

    private RecyclerView recyclerView;
    private AdapterAssunto adapterAssunto;
    private List<Assunto> assuntoList;
    private MainActivity mActivity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assuntoList = new ArrayList<>();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_assunto, container, false);
        inicializaControles(view);
        return view;
    }

    private void inicializaControles(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = (MainActivity) getActivity();
        mActivity.toolbar.setTitle("Assuntos");
        configuraAdapter();
        configuraRecyclerView();
        carregaDados();
        setHasOptionsMenu(true);
    }

    private void carregaDados() {
        assuntoList.clear();
        assuntoList.add(new Assunto(0, "teste 1", R.color.amarelo));
        assuntoList.add(new Assunto(0, "teste 2", R.color.amarelo_claro));
        adapterAssunto.notifyDataSetChanged();

    }

    private void configuraRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.setAdapter(adapterAssunto);

    }

    private void configuraAdapter() {
        adapterAssunto = new AdapterAssunto(assuntoList, this);
    }

    @Override
    public void OnClick(Assunto assunto) {
        mActivity.montaViewPergunta(assunto);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_assunto, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_add){
            mActivity.montaViewCadastraAssunto();
        }
        return super.onOptionsItemSelected(item);

    }
}
