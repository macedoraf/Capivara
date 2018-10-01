package br.com.fiap.genk.genk.view.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Encontro;
import br.com.fiap.genk.genk.view.EncontroView;
import br.com.fiap.genk.genk.view.activity.MainActivity;
import br.com.fiap.genk.genk.view.activity.MapsActivity;
import br.com.fiap.genk.genk.view.adapter.AdapterEncontro;
import br.com.fiap.genk.genk.view.adapter.EncontroListener;

public class FragmentEncontro extends Fragment implements EncontroListener, EncontroView {

    private RecyclerView recyclerView;
    private MainActivity mActivity;
    private AdapterEncontro mAdapter;
    private List<Encontro> encontroList;
    private ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
        encontroList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.fragment_encontro, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity.toolbar.setTitle("Encontros");
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new AdapterEncontro(encontroList, this);
        recyclerView.setAdapter(mAdapter);
        setHasOptionsMenu(true);

    }

    @Override
    public void onClickMap() {
        startActivity(new Intent(mActivity, MapsActivity.class));
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void atualizaAdapter() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void carregaDados(List<Encontro> encontroList) {
        encontroList.clear();
        encontroList.addAll(encontroList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_encontro) {
            showTelaAddEncontro();
            return true;
        }
        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_encontro, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void showTelaAddEncontro() {
        Toast.makeText(mActivity, "True ", Toast.LENGTH_SHORT).show();
    }


}
