package br.com.fiap.genk.genk.model.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Assunto;

@Dao
public interface AssuntoDAO {

    @Insert
    void insert(Assunto assunto);

    @Query("SELECT * FROM Assunto")
    List<Assunto> getAll();

    @Update
    void update(Assunto assunto);

    @Delete
    void delete(Assunto assunto);

}
