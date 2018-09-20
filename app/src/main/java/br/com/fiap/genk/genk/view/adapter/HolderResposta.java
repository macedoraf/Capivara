package br.com.fiap.genk.genk.view.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Resposta;

public class HolderResposta extends RecyclerView.ViewHolder implements View.OnClickListener {

    private CardView cardView;

    private TextView lblAutor;

    private TextView lblResposta;

    private TextView lblQtdLike;

    private Resposta resposta;
    private final AdapterResposta.RespostaListener listener;

    public HolderResposta(View itemView, AdapterResposta.RespostaListener listener) {
        super(itemView);
        this.listener = listener;
        cardView = itemView.findViewById(R.id.cardView);
        lblAutor = itemView.findViewById(R.id.lblAutor);
        lblResposta = itemView.findViewById(R.id.lblResposta);
        lblQtdLike = itemView.findViewById(R.id.lblQtdLike);
        cardView.setOnClickListener(this);

    }

    public void bind(Resposta res) {
        resposta = res;
        lblAutor.setText(res.getAutor());
        lblResposta.setText(res.getTexto());
        lblQtdLike.setText(String.valueOf(res.getQtdLike()));

    }

    @Override
    public void onClick(View view) {
        listener.onLinke();
    }
}
