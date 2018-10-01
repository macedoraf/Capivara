package br.com.fiap.genk.genk.view.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import br.com.fiap.genk.genk.model.entity.Encontro;
import br.com.fiap.genk.genk.view.adapter.EncontroListener;

public class EncontroHolder extends RecyclerView.ViewHolder {

    private Encontro encontro;
    private EncontroListener encontroListener;

    public EncontroHolder(View itemView, EncontroListener encontroListener) {
        super(itemView);
        this.encontroListener = encontroListener;

    }

    public void bind(Encontro encontro) {
        this.encontro = encontro;

    }
}
