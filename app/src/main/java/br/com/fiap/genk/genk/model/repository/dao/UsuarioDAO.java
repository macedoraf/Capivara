package br.com.fiap.genk.genk.model.repository.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import br.com.fiap.genk.genk.model.entity.Usuario;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM usuario WHERE email = :email AND senha = :senha")
    Usuario getUsuario(String email, String senha);

    @Insert
    void insertUsuario(Usuario usuario);

}
