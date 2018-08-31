package br.com.fiap.genk.genk.model.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.model.entity.Usuario;
import br.com.fiap.genk.genk.model.repository.dao.AssuntoDAO;
import br.com.fiap.genk.genk.model.repository.dao.PerguntaDAO;
import br.com.fiap.genk.genk.model.repository.dao.UsuarioDAO;

@Database(entities = {Pergunta.class, Usuario.class, Assunto.class}, version = 3)
public abstract class GenkDatabase extends RoomDatabase {

    public abstract PerguntaDAO perguntaDAO();

    public abstract UsuarioDAO usuarioDAO();

    public abstract AssuntoDAO assuntoDAO();
}
