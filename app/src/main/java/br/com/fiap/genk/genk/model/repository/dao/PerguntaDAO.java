package br.com.fiap.genk.genk.model.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Pergunta;

@Dao
public interface PerguntaDAO {

    @Query("SELECT * FROM pergunta")
    List<Pergunta> getAll();

    @Query("SELECT * FROM pergunta WHERE topico LIKE :titulo")
    List<Pergunta> findByTitulo(String titulo);

    @Insert
    void insertAll(List<Pergunta> perguntas);

    @Update
    void update(Pergunta product);

    @Delete
    void delete(Pergunta product);

    @Insert
    void insert(Pergunta pergunta);
}
