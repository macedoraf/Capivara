package br.com.fiap.genk.genk.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.RespostaLike;
import br.com.fiap.genk.genk.view.adapter.holder.HolderResposta;

public class AdapterResposta extends RecyclerView.Adapter<HolderResposta> {

    private final List<RespostaLike> respostaList;
    private final RespostaListener listener;

    public AdapterResposta(List<RespostaLike> respostaList, RespostaListener listener) {
        this.respostaList = respostaList;
        this.listener = listener;
    }

    @Override
    public HolderResposta onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HolderResposta(LayoutInflater.from(parent.getContext()).inflate(R.layout.lst_resposta, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(HolderResposta holder, int position) {
        holder.bind(respostaList.get(position));


    }

    @Override
    public int getItemCount() {
        return respostaList.size();
    }

    public interface RespostaListener {
        void onLinke();
    }
}
