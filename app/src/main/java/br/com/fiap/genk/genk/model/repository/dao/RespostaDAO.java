package br.com.fiap.genk.genk.model.repository.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.model.entity.Resposta;

@Dao
public interface RespostaDAO {

    @Query("SELECT * FROM Resposta WHERE codigoPergunta = :pergundaId ORDER BY codigo DESC")
    List<Resposta> getRespostas(int pergundaId);
    @Insert
    void insertResposta(Resposta resposta);


}
