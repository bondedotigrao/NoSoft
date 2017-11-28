package model.DAO;

import model.Administrador;

/**
 *
 * @author Jarvis
 */
public interface AdministradorDAO extends DAO<Administrador>{
    boolean login(String login,String senha);
}
