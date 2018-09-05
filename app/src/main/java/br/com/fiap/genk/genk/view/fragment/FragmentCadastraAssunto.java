package br.com.fiap.genk.genk.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.presenter.AssuntoPresenter;
import br.com.fiap.genk.genk.presenter.AssuntoPresenterImpl;
import br.com.fiap.genk.genk.view.AssuntoView;
import br.com.fiap.genk.genk.view.activity.MainActivity;

public class FragmentCadastraAssunto extends Fragment implements View.OnClickListener, AssuntoView {

    private Button btnSalvar;
    private EditText edtNomeAssunto;
    private Spinner spCor;
    private AssuntoPresenter presenter;
    private MainActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AssuntoPresenterImpl(this);
        mActivity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastra_assunto, container, false);
        inicializaComponentes(view);
        return view;
    }

    private void inicializaComponentes(View view) {
        btnSalvar = view.findViewById(R.id.btnSalvar);
        edtNomeAssunto = view.findViewById(R.id.edtNomeAssunto);
        spCor = view.findViewById(R.id.spCor);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        configuraListeners();
    }

    private void configuraListeners() {
        btnSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        presenter.insertAll(new Assunto(edtNomeAssunto.getText().toString(), 0));

    }

    @Override
    public void atualizaLista(List<Assunto> assuntoList) {
        mActivity.onBackPressed();

    }
}

