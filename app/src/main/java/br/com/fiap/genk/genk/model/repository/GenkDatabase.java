package br.com.fiap.genk.genk.model.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import br.com.fiap.genk.genk.model.entity.Assunto;
import br.com.fiap.genk.genk.model.entity.Encontro;
import br.com.fiap.genk.genk.model.entity.EncontroUsuario;
import br.com.fiap.genk.genk.model.entity.Laike;
import br.com.fiap.genk.genk.model.entity.Pergunta;
import br.com.fiap.genk.genk.model.entity.Resposta;
import br.com.fiap.genk.genk.model.entity.Usuario;
import br.com.fiap.genk.genk.model.repository.dao.AssuntoDAO;
import br.com.fiap.genk.genk.model.repository.dao.EncontroDAO;
import br.com.fiap.genk.genk.model.repository.dao.EncontroUserDAO;
import br.com.fiap.genk.genk.model.repository.dao.LikeDAO;
import br.com.fiap.genk.genk.model.repository.dao.PerguntaDAO;
import br.com.fiap.genk.genk.model.repository.dao.RespostaDAO;
import br.com.fiap.genk.genk.model.repository.dao.UsuarioDAO;

@Database(entities = {Pergunta.class, Usuario.class, Assunto.class, Resposta.class, Laike.class, Encontro.class, EncontroUsuario.class}, version = 9)
public abstract class GenkDatabase extends RoomDatabase {

    public abstract PerguntaDAO perguntaDAO();

    public abstract UsuarioDAO usuarioDAO();

    public abstract AssuntoDAO assuntoDAO();

    public abstract RespostaDAO respostaDAO();

    public abstract LikeDAO likeDao();

    public abstract EncontroUserDAO encontroUsuarioDao();

    public abstract EncontroDAO encontroDao();
}
