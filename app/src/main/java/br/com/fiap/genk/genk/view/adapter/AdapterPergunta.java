package br.com.fiap.genk.genk.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.view.adapter.holder.PerguntaHolder;

public class AdapterPergunta extends RecyclerView.Adapter<PerguntaHolder> {
    private final List<Pergunta> perguntaList;
    private final PerguntaListener listener;

    public AdapterPergunta(List<Pergunta> perguntaList, PerguntaListener listener) {
        this.perguntaList = perguntaList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public PerguntaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PerguntaHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lst_pergunta, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PerguntaHolder holder, int position) {
        holder.bind(perguntaList.get(position));

    }

    @Override
    public int getItemCount() {
        return perguntaList.size();
    }


    public interface PerguntaListener {
        void onClick(Pergunta pergunta);
    }
}
