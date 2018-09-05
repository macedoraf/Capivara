package br.com.fiap.genk.genk.view.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.fiap.genk.genk.model.entity.Resposta;

public class HolderResposta extends RecyclerView.ViewHolder implements View.OnClickListener {

    private CardView cardView;

    private Resposta resposta;
    private final AdapterResposta.RespostaListener listener;

    public HolderResposta(View itemView, AdapterResposta.RespostaListener listener) {
        super(itemView);
        this.listener = listener;
        cardView.setOnClickListener(this);
    }

    public void bind(Resposta res) {
        resposta = res;

    }

    @Override
    public void onClick(View view) {
        listener.onLinke();
    }
}
