package br.com.fiap.genk.genk.model.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Laike;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface LikeDAO {

    @Insert(onConflict = REPLACE)
    void insertLike(Laike laike);

    @Query("SELECT * FROM Laike WHERE codigoResposta = :codigoResposta")
    List<Laike> getLikesByResposta(Integer codigoResposta);


}
