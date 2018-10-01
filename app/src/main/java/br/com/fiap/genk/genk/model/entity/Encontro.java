package br.com.fiap.genk.genk.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Calendar;
import java.util.Date;

import br.com.fiap.genk.genk.utill.DateTypeConverter;

@Entity
public class Encontro {
    @PrimaryKey
    private int codigo;
    @TypeConverters(DateTypeConverter.class)
    private Date dataHoraEncontro;
    private long latitude;
    private long longetude;
    private int codigoUsuarioAutor;


    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongetude() {
        return longetude;
    }

    public void setLongetude(long longetude) {
        this.longetude = longetude;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public Date getDataHoraEncontro() {
        return dataHoraEncontro;
    }

    public void setDataHoraEncontro(Date dataHoraEncontro) {
        this.dataHoraEncontro = dataHoraEncontro;
    }

    public int getCodigoUsuarioAutor() {
        return codigoUsuarioAutor;
    }

    public void setCodigoUsuarioAutor(int codigoUsuarioAutor) {
        this.codigoUsuarioAutor = codigoUsuarioAutor;
    }
}
