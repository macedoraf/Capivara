package br.com.fiap.genk.genk.view.adapter.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.view.adapter.AdapterPergunta;

public class PerguntaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final AdapterPergunta.PerguntaListener listener;
    private Pergunta pergunta;
    private TextView lblTitulo;
    private TextView lblAutor;
    private TextView lblQtdLike;
    private TextView lblId;
    private ImageView imgLike;
    private CardView cardView;


    public PerguntaHolder(View itemView, AdapterPergunta.PerguntaListener listener) {
        super(itemView);
        this.listener = listener;
        lblTitulo = itemView.findViewById(R.id.lblTitulo);
        lblAutor = itemView.findViewById(R.id.lblAutor);
        lblQtdLike = itemView.findViewById(R.id.lblQtdLike);
        cardView = itemView.findViewById(R.id.cardView);
        cardView.setOnClickListener(this);


    }


    public void bind(Pergunta pergunta) {
        this.pergunta = pergunta;
        lblTitulo.setText(pergunta.getTitulo());
        lblAutor.setText(pergunta.getAutor());
        lblQtdLike.setText(pergunta.getLike() + "");
    }

    @Override
    public void onClick(View view) {
        if (view == cardView) {
            listener.onClick(pergunta);
        }
    }
}
