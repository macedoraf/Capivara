package br.com.fiap.genk.genk.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Calendar;

@Entity
public class Encontro {
    @PrimaryKey
    private int codigo;
    private Calendar dataHoraEncontro;
    //TODO: COORDENADAS
    private int codigoUsuarioAutor;
    //TODO: TABELA ASSOCIATIVA DE ENCONTROS X USUARIOS

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Calendar getDataHoraEncontro() {
        return dataHoraEncontro;
    }

    public void setDataHoraEncontro(Calendar dataHoraEncontro) {
        this.dataHoraEncontro = dataHoraEncontro;
    }

    public int getCodigoUsuarioAutor() {
        return codigoUsuarioAutor;
    }

    public void setCodigoUsuarioAutor(int codigoUsuarioAutor) {
        this.codigoUsuarioAutor = codigoUsuarioAutor;
    }
}
