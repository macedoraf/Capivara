package br.com.fiap.genk.genk.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Encontro;
import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.view.adapter.holder.EncontroHolder;
import br.com.fiap.genk.genk.view.adapter.holder.PerguntaHolder;

public class AdapterEncontro extends RecyclerView.Adapter<EncontroHolder> {
    private final List<Encontro> encontroList;
    private final EncontroListener listener;

    public AdapterEncontro(List<Encontro> encontroList, EncontroListener listener) {
        this.encontroList = encontroList;
        this.listener = listener;
    }


    @NonNull
    @Override
    public EncontroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EncontroHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lst_encontro, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(EncontroHolder holder, int position) {
        holder.bind(encontroList.get(position));

    }


    @Override
    public int getItemCount() {
        return encontroList.size();
    }


    public interface PerguntaListener {
        void onClick(Pergunta pergunta);
    }
}
