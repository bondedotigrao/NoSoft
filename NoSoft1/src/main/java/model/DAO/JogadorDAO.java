package model.DAO;

import model.Jogador;

/**
 *
 * @author Jarvis
 */
public interface JogadorDAO extends DAO<Jogador> {
    boolean login(String login,String senha);
}
