package br.com.fiap.genk.genk.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.emrekose.recordbutton.OnRecordListener;
import com.emrekose.recordbutton.RecordButton;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.presenter.AssuntoPresenter;
import br.com.fiap.genk.genk.presenter.AssuntoPresenterImpl;
import br.com.fiap.genk.genk.presenter.PerguntaPresenter;
import br.com.fiap.genk.genk.presenter.PerguntaPresenterImpl;
import br.com.fiap.genk.genk.view.AssuntoView;
import br.com.fiap.genk.genk.view.GenkApplication;
import br.com.fiap.genk.genk.view.PerguntaView;
import br.com.fiap.genk.genk.view.activity.MainActivity;

public class FragmentCadastraPergunta extends Fragment implements OnRecordListener, View.OnClickListener, AssuntoView, PerguntaView {

    private MainActivity mActivity;
    private RecordButton btnRecord;
    private Spinner spAssunto;
    private EditText edtTitulo;
    private Button btnSalvar;
    private List<Assunto> assuntoList;
    private ArrayAdapter adapter;
    private AssuntoPresenter assuntoPresenter;
    private PerguntaPresenter perguntaPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
        assuntoList = new ArrayList<>();
        assuntoPresenter = new AssuntoPresenterImpl(this);
        perguntaPresenter = new PerguntaPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastra_pergunta, container, false);
        btnRecord = view.findViewById(R.id.btnRecord);
        spAssunto = view.findViewById(R.id.spAssunto);
        edtTitulo = view.findViewById(R.id.edtTitulo);
        btnSalvar = view.findViewById(R.id.btnSalvar);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity.toolbar.setTitle("Cadastrar Pergunta");
        btnRecord.setRecordListener(this);
        btnSalvar.setOnClickListener(this);
        configuraAdapter();
        carregaListaAssuntos();
    }

    private void configuraAdapter() {
        adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_spinner_dropdown_item, assuntoList);
        spAssunto.setAdapter(adapter);
    }

    private void carregaListaAssuntos() {
        assuntoPresenter.getUnique();
    }


    @Override
    public void onRecord() {

    }

    @Override
    public void onRecordCancel() {

    }

    @Override
    public void onRecordFinish() {

    }

    @Override
    public void onClick(View view) {
        salvaPergunta();
    }

    private void salvaPergunta() {
        perguntaPresenter.cadastraPergunta(new Pergunta(edtTitulo.getText().toString(),
                mActivity.toolbar.getSubtitle().toString(), edtTitulo.getText().toString(),
                "", GenkApplication.getInstance().getUsuarioLogado().getNome()));
    }

    @Override
    public void atualizaLista(List<Assunto> assuntoList) {
        this.assuntoList.clear();
        this.assuntoList.addAll(assuntoList);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void atualizaAdapter() {
        mActivity.onBackPressed();
    }

    @Override
    public List<Pergunta> getListaPergunta() {
        return null;
    }
}
