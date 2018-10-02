package br.com.fiap.genk.genk.model.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Encontro;

@Dao
public interface EncontroDAO {

    @Query("SELECT * FROM Encontro WHERE codigoUsuarioAutor = :idUsuario")
    List<Encontro> selectEncontroByUsuario(int idUsuario);

    @Insert
    void insert(Encontro encontro);
}
