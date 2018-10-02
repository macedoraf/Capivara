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
import java.util.Calendar;
import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Encontro;
import br.com.fiap.genk.genk.presenter.EncontroPresenter;
import br.com.fiap.genk.genk.presenter.EncontroPresenterImpl;
import br.com.fiap.genk.genk.view.EncontroView;
import br.com.fiap.genk.genk.view.GenkApplication;
import br.com.fiap.genk.genk.view.activity.MainActivity;
import br.com.fiap.genk.genk.view.activity.MapsActivity;
import br.com.fiap.genk.genk.view.adapter.AdapterEncontro;
import br.com.fiap.genk.genk.view.adapter.EncontroListener;

import static android.app.Activity.RESULT_OK;

public class FragmentEncontro extends Fragment implements EncontroListener, EncontroView {

    private static final int RESULT_CODE_MAP_ADD = 222;
    private RecyclerView recyclerView;
    private MainActivity mActivity;
    private AdapterEncontro mAdapter;
    private List<Encontro> encontroList;
    private ProgressBar progressBar;
    private EncontroPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
        encontroList = new ArrayList<>();
        presenter = new EncontroPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.fragment_encontro, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.carregaDados();
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
        startActivityForResult(new Intent(mActivity, MapsActivity.class), RESULT_CODE_MAP_ADD);
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
        this.encontroList.clear();
        this.encontroList.addAll(encontroList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_encontro) {
            showTelaAddEncontro();
            return false;
        }
        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_encontro, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void showTelaAddEncontro() {
        startActivityForResult(new Intent(mActivity, MapsActivity.class), RESULT_CODE_MAP_ADD);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_CODE_MAP_ADD) {
                double lat = data.getExtras().getDouble("lat", 0D);
                double log = data.getExtras().getDouble("long", 0D);
                String ende = data.getExtras().getString("ende", "");
                String titulo = data.getExtras().getString("titulo", "(SEM TITULO)");
                Calendar calendar = (Calendar) data.getExtras().getSerializable("data");
                Encontro encontro = new Encontro();
                encontro.setCodigoUsuarioAutor(GenkApplication.getInstance().getUsuarioLogado().getId());
                encontro.setDataHoraEncontro(calendar.getTime());
                encontro.setLatitude(lat);
                encontro.setLongetude(log);
                encontro.setEndereco(ende);
                encontro.setTitulo(titulo);
                presenter.inserirEncontro(encontro);


            }
        }
    }
}
