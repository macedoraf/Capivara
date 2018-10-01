package br.com.fiap.genk.genk.model.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Encontro;
import br.com.fiap.genk.genk.model.entity.EncontroUsuario;
import br.com.fiap.genk.genk.model.entity.Usuario;

@Dao
public interface EncontroUserDAO {

    @Insert
    void insert(EncontroUsuario encontroUsuario);

    @Query("SELECT * FROM usuario INNER JOIN encontro_user_repo ON (id = userId) WHERE encontroId = :encontroId")
    List<Usuario> getUserForEncontro(final int encontroId);

    @Query("SELECT * FROM ENCONTRO INNER JOIN encontro_user_repo ON (encontroId = codigo) WHERE userId = :userId")
    List<Encontro> getEncontroForUser(final int userId);

    @Delete
    void delete(Encontro encontro);

    @Update
    void update(Encontro encontro);


}
