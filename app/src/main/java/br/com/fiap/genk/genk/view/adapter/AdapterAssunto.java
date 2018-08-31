package br.com.fiap.genk.genk.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.view.adapter.holder.AssuntoHolder;

public class AdapterAssunto extends RecyclerView.Adapter<AssuntoHolder> {

    private final List<Assunto> assuntoList;
    private final AssuntoListener listener;

    public AdapterAssunto(List<Assunto> assuntoList, AssuntoListener listener) {
        this.assuntoList = assuntoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AssuntoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AssuntoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lst_assunto, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AssuntoHolder holder, int position) {
        holder.bind(assuntoList.get(position));

    }

    @Override
    public int getItemCount() {
        return assuntoList.size();
    }


    public interface AssuntoListener {

        void OnClick(Assunto assunto);
    }
}
