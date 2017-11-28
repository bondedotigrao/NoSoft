package model.implmentacoes.hibernate;

import java.util.List;
import model.DAO.JogoDAO;
import model.Jogo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jarvis
 */
public class JogoHibernateDAO implements JogoDAO{
    private SessionFactory sessions;
    private JogoHibernateDAO instance;
    
    public JogoHibernateDAO getInstance(){
        if(instance == null){
            instance = new JogoHibernateDAO();
    }
    return instance;
}

    @Override
    public void cadastrar(Jogo jogo) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.persist(jogo);
            t.commit();
        }catch(Exception cadJogoError){
            System.out.println(cadJogoError.getCause()
                            + "\nOcorreu um erro ao cadastrar um Jogo.");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Jogo recuperar(int codigo) {
        Session session = this.sessions.openSession();
        
        try{
           return (Jogo) session.createQuery("From jogo Where id_jogo=" + codigo).
                   getResultList().get(0);
        }catch(Exception recuperaJogoError){
            System.out.println(recuperaJogoError.getCause()
                              + "\nOcorreu um erro ao recuperar um Jogo.");
        }finally{
            
        }
        return null;
    }

    @Override
    public void deletar(Jogo jogo) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.delete(jogo);
            t.commit();
        }catch(Exception delJogoError){
            System.out.println(delJogoError.getCause()
                            + "\nOcorreu um erro ao deletar um Jogo.");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void alterar(Jogo jogo) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.update(jogo);
            t.commit();
        }catch(Exception updateJogoError){
            System.out.println(updateJogoError.getCause()
                            + "\nOcorreu um erro ao alterar um Jogo.");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Jogo> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Jogo> listJogos = this.recuperarTodos();
        try{
           listJogos = session.createQuery("From jogo").getResultList();
        }catch(Exception recuperaTodosJogosError){
            System.out.println(recuperaTodosJogosError.getCause()
                            + "\nOcorreu um erro ao recuperar todos os Jogos.");
        }finally{
            session.close();
        }
        return listJogos;
    }
    
}