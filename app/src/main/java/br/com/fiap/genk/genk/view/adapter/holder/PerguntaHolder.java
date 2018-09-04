package br.com.fiap.genk.genk.view.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.view.adapter.AdapterPergunta;

public class PerguntaHolder extends RecyclerView.ViewHolder {
    private final AdapterPergunta.PerguntaListener listener;
    private Pergunta pergunta;
    private TextView lblTitulo;
    private TextView lblAutor;
    private TextView lblQtdLike;
    private ImageView imgLike;


    public PerguntaHolder(View itemView, AdapterPergunta.PerguntaListener listener) {
        super(itemView);
        this.listener = listener;
        lblTitulo = itemView.findViewById(R.id.lblTitulo);
        lblAutor = itemView.findViewById(R.id.lblAutor);
        lblQtdLike = itemView.findViewById(R.id.lblQtdLike);


    }


    public void bind(Pergunta pergunta) {
        this.pergunta = pergunta;
        lblTitulo.setText(pergunta.getTitulo());
        lblAutor.setText(pergunta.getAutor());
        lblQtdLike.setText(pergunta.getLike());
    }
}
