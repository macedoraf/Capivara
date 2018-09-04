package br.com.fiap.genk.genk.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.emrekose.recordbutton.OnRecordListener;
import com.emrekose.recordbutton.RecordButton;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.view.activity.MainActivity;

public class FragmentCadastraPergunta extends Fragment implements OnRecordListener, View.OnClickListener {

    private MainActivity mActivity;
    private RecordButton btnRecord;
    private Spinner spAssunto;
    private EditText edtTitulo;
    private Button btnSalvar;
    private List<Assunto> assuntoList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
        assuntoList = new ArrayList<>();
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
        carregaListaAssuntos();
    }

    private void carregaListaAssuntos() {

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

    }
}
