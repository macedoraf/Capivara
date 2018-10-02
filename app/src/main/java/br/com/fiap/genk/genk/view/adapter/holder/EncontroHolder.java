package br.com.fiap.genk.genk.view.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import br.com.fiap.genk.genk.R;
import br.com.fiap.genk.genk.model.entity.Encontro;
import br.com.fiap.genk.genk.view.adapter.EncontroListener;

public class EncontroHolder extends RecyclerView.ViewHolder {

    private Encontro encontro;
    private EncontroListener encontroListener;

    private TextView lblTitulo;

    private TextView lblEndereco;

    private TextView lblDataHora;

    public EncontroHolder(View itemView, EncontroListener encontroListener) {
        super(itemView);
        this.encontroListener = encontroListener;
        lblTitulo = itemView.findViewById(R.id.lblTitulo);
        lblEndereco = itemView.findViewById(R.id.lblEndereco);
        lblDataHora = itemView.findViewById(R.id.lblDataHora);

    }

    public void bind(Encontro encontro) {
        this.encontro = encontro;

        lblTitulo.setText(encontro.getTitulo());

        lblEndereco.setText(encontro.getEndereco());

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        lblDataHora.setText(dateFormat.format(encontro.getDataHoraEncontro()));

    }
}
