package model.implmentacoes.hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import model.Arma;
import model.DAO.ArmaDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jarvis
 */
public class ArmaHibernateDAO implements ArmaDAO{
    private SessionFactory sessions;
    private static ArmaHibernateDAO instance = null;
    
    public static ArmaHibernateDAO getInstance(){
        if(instance == null){
            instance = new ArmaHibernateDAO();
        }
        return instance;
    }
    
    public ArmaHibernateDAO(){
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void cadastrar(Arma arma) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.persist(arma);
            t.commit();
        }catch(Exception cadArmaError){
            System.out.println(cadArmaError.getCause() + "\nOcorreu um erro ao cadastrar uma arma");
            t.rollback();
        }finally{
        session.close();;
    }
    }

    @Override
    public Arma recuperar(int codigo) {
        Session session = this.sessions.openSession();
        
        try{
            return (Arma) session.createQuery("From arma Where id_arma=" + codigo).getResultList().get(0);
        }catch(Exception recuperaArmaError){
            System.out.println("Ocorreu um erro ao recuperar uma Arma.");
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void deletar(Arma arma) {
          Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.delete(arma);
            t.commit();
        }catch(Exception delArmaError){
            System.out.println(delArmaError.getCause() 
                    + "\nOcorreu um erro ao deletar uma Arma!");
            t.rollback();
        }finally{
        session.close();;
    }
    }

    @Override
    public void alterar(Arma arma) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.update(arma);
            t.commit();
        }catch(Exception updateArmaError){
            System.out.println(updateArmaError.getCause() + 
                    "\nOcorreu um erro ao alterar uma Arma.");
            t.rollback();
        }finally{
        session.close();;
    }
    }

    @Override
    public List<Arma> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Arma> listArmas = null;
        
        try{
           listArmas = session.createQuery("From arma").getResultList();
        }catch(Exception recuperaTodasArmasError){
            System.out.println("Ocorreu um erro ao recuperar todas as Armas.");
        }finally{
            session.close();
        }
        return listArmas;
    }
    
}
