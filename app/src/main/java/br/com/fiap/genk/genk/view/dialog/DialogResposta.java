package br.com.fiap.genk.genk.view.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.model.entity.Resposta;
import br.com.fiap.genk.genk.model.entity.RespostaLike;
import br.com.fiap.genk.genk.presenter.RespostaPresenter;
import br.com.fiap.genk.genk.presenter.RespostaPresenterImpl;
import br.com.fiap.genk.genk.view.GenkApplication;
import br.com.fiap.genk.genk.view.RespostaView;
import br.com.fiap.genk.genk.view.activity.MainActivity;
import br.com.fiap.genk.genk.view.adapter.AdapterResposta;

public class DialogResposta extends DialogFragment implements View.OnClickListener, RespostaView, AdapterResposta.RespostaListener {

    private Pergunta pergunta;

    private AlertDialog mAlertDialog;

    private MainActivity mActivity;

    private View mView;

    private android.support.v7.widget.Toolbar toolbar;

    private TextView lblDescricao;

    private Button btnAdicionaResposta;

    private EditText edtResposta;

    private List<RespostaLike> respostaList;

    private RespostaPresenter presenter;

    private AdapterResposta adapterResposta;

    private RecyclerView recyclerView;


    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        respostaList = new ArrayList<>();
        mActivity = (MainActivity) getActivity();
        presenter = new RespostaPresenterImpl(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        try {

            inicializaControles();
            configuraAdapter();

            mAlertDialog = new AlertDialog.Builder(mActivity)
                    .setView(mView)
                    .setIcon(null)
                    .create();

        } catch (Exception err) {
            err.printStackTrace();
        }
        return mAlertDialog;
    }

    private void configuraAdapter() {
        adapterResposta = new AdapterResposta(respostaList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterResposta);
    }

    private void inicializaControles() {
        mView = View.inflate(mActivity, R.layout.dialog_pergunta, null);
        toolbar = mView.findViewById(R.id.toolbar);
        lblDescricao = mView.findViewById(R.id.lblDescricao);
        btnAdicionaResposta = mView.findViewById(R.id.btnAdicionaResposta);
        edtResposta = mView.findViewById(R.id.edtResposta);
        recyclerView = mView.findViewById(R.id.recyclerView);

    }

    public void show(FragmentManager manager) {
        super.show(manager, this.getClass().getSimpleName());
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lblDescricao.setText(pergunta.getDescricao());
        toolbar.setTitle(pergunta.getTitulo());
        toolbar.setTitleTextColor(Color.WHITE);
        btnAdicionaResposta.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        atualizaDados();
    }

    @Override
    public void onClick(View view) {
        Resposta resposta = new Resposta();
        resposta.setAutor(GenkApplication.getInstance().getUsuarioLogado().getNome());
        resposta.setCodigoPergunta(pergunta.getId());
        resposta.setTexto(edtResposta.getText().toString());
        presenter.insereResposta(resposta);

    }

    @Override
    public List<RespostaLike> getRespostaList() {
        return respostaList;
    }

    @Override
    public void atualizaDados() {
        presenter.carregaRespostas(pergunta);
        adapterResposta.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void onLinke() {

    }
}
