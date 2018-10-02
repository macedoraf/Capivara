package br.com.fiap.genk.genk.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Calendar;
import java.util.Date;

import br.com.fiap.genk.genk.utill.DateTypeConverter;

@Entity
public class Encontro {
    @PrimaryKey(autoGenerate = true)
    private int codigo;
    @TypeConverters(DateTypeConverter.class)
    private Date dataHoraEncontro;
    private double latitude;
    private double longetude;
    private String endereco;
    private int codigoUsuarioAutor;
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongetude() {
        return longetude;
    }

    public void setLongetude(double longetude) {
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
