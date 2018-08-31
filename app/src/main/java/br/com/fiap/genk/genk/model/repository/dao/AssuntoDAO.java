package br.com.fiap.genk.genk.model.repository.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Assunto;

@Entity
public interface AssuntoDAO {

    @Query("SELECT * FROM Assunto")
    List<Assunto> getAll();

    @Query("SELECT * FROM Assunto")
    Assunto findByTitulo(String titulo);


    @Update
    void update(Assunto assunto);

    @Delete
    void delete(Assunto assunto);
}
