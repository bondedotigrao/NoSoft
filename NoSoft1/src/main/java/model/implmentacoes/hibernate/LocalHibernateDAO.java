package model.implmentacoes.hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import model.DAO.LocalDAO;
import model.Local;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jarvis
 */
public class LocalHibernateDAO implements LocalDAO {
    private SessionFactory sessions;
    private static LocalHibernateDAO instance;
    
    public static LocalHibernateDAO getInstance(){
        if(instance == null){
            instance = new LocalHibernateDAO();
        }
        
        return instance;
    }
    
    public LocalHibernateDAO(){
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void cadastrar(Local local) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.persist(local);
            t.commit();
        }catch(Exception cadLocalError){
            System.out.println(cadLocalError.getCause() + "\nOcorreu um erro ao cadastar um local");
            t.rollback();
        }finally{
            session.close();
        }
    }
    
    @Override
    public Local recuperar(int codigo) {
        Session session = this.sessions.openSession();
        
        try{
            return (Local) session.createQuery(
                    "From local Where id_local=" + codigo).getResultList().get(0);
        }catch(Exception recuperaLocalErorr){
            System.out.println("Ocorreu um erro ao recuperar um Local.");
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void deletar(Local local) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.delete(local);
            t.commit();
        }catch(Exception delLocalError){
            System.out.println(delLocalError.getCause() 
                    + "\nOcorreu um erro ao deletar um local");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void alterar(Local local) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.update(local);
            t.commit();
        }catch(Exception updateLocalError){
            System.out.println(updateLocalError.getCause() 
                    + "\nOcorreu um erro ao alterar um local");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Local> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Local> listLocal = null;
        try{
           listLocal = session.createQuery("From local").getResultList();
        }catch(Exception recuperaTodosLocaisError){
            System.out.println(recuperaTodosLocaisError.getCause() +
                    "\nOcorreu um erro ao recuperar os Locais.");
        }finally{
            session.close();
        }
        return listLocal;
    }
}
