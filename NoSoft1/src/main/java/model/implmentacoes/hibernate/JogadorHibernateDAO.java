package model.implmentacoes.hibernate;

import java.util.List;
import model.DAO.JogadorDAO;
import model.Jogador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jarvis
 */
public class JogadorHibernateDAO implements JogadorDAO{
    private SessionFactory sessions;
    private JogadorHibernateDAO instance;
    
    public JogadorHibernateDAO getInstance(){
        if(instance == null){
            instance = new JogadorHibernateDAO();
        }
        return instance;
    }

    public JogadorHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void cadastrar(Jogador jogador) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.persist(jogador);
            t.commit();
        }catch(Exception cadJogadorError){
            System.out.println(cadJogadorError.getCause()
                                + "\nOcorreu um erro ao cadastrar um jogador.");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Jogador recuperar(int codigo) {
      Session session = this.sessions.openSession();
      
      try{
          return (Jogador) session.createQuery("From jogador Where id_jogador=" + codigo
                                    ).getResultList().get(0);
      }catch(Exception recuperaJogadorError){
          System.out.println(recuperaJogadorError.getCause()
                            + "\nOcorreu um erro ao recuperar um jogador");
      }finally{
          session.close();
      }
      return null;
    }

    @Override
    public void deletar(Jogador jogador) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.delete(jogador);
            t.commit();
        }catch(Exception delJogadorError){
            System.out.println(delJogadorError.getCause()
                                + "\nOcorreu um erro ao deletar um jogador.");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void alterar(Jogador jogador) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.update(jogador);
            t.commit();
        }catch(Exception updateJogadorError){
            System.out.println(updateJogadorError.getCause()
                                + "\nOcorreu um erro ao alterar um jogador.");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Jogador> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Jogador> listPlayer = null;
        
        try{
            listPlayer = session.createQuery("From Jogador").getResultList();
        }catch(Exception recuperaTodosJogadores){
            System.out.println(recuperaTodosJogadores.getCause()
                                + "\nOcorreu um erro ao recuperar todos os Jogadores.");
        }finally{
            session.close();
        }
        return listPlayer;
    }
    @Override
    public boolean login(String login, String senha) {
        List<Jogador> jogadores = this.recuperarTodos();
        
        for(Jogador player : jogadores){
            if(player.getLogin().equals(login)
                    && player.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}
