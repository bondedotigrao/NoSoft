package model.implementacoes;

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
    private EntityManager em;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Local t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Local t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Local> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
