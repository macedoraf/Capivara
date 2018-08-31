package br.com.fiap.genk.genk.view.adapter.holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.view.adapter.AdapterAssunto;

public class AssuntoHolder extends RecyclerView.ViewHolder {

    private Assunto assunto;
    private final AdapterAssunto.AssuntoListener listener;

    private CardView cardView;
    private TextView lblTitulo;

    public AssuntoHolder(View itemView, AdapterAssunto.AssuntoListener listener) {
        super(itemView);
        this.listener = listener;
        cardView = itemView.findViewById(R.id.cardView);
        lblTitulo = itemView.findViewById(R.id.lblTitulo);
    }

    public void bind(Assunto assunto) {
        this.assunto = assunto;
        lblTitulo.setText(assunto.getTitulo());
    }
}
