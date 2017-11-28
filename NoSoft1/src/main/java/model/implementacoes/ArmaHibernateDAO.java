package model.implementacoes;

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
    private EntityManager em;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Arma t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Arma t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Arma> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
