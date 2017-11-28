package model.implmentacoes.hibernate;

import java.util.List;
import model.DAO.TimeDAO;
import model.Time;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jarvis
 */
public class TimeHibernateDAO implements TimeDAO{
    private SessionFactory sessions;
    private TimeHibernateDAO instance;
    
    public TimeHibernateDAO getInstance(){
        if(instance == null){
            instance = new TimeHibernateDAO();
        }
        return instance;
    }

    public TimeHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void cadastrar(Time time) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.persist(time);
            t.commit();
        }catch(Exception cadTimeError){
            System.out.println(cadTimeError.getCause()
                            + "\nOcorreu um erro ao cadastrar um Time.");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Time recuperar(int codigo) {
        Session session = this.sessions.openSession();
        
        try{
            return (Time) session.createQuery("From time Where id_time=" + codigo)
                    .getResultList().get(0);
        }catch(Exception recuperaTimeError){
            System.out.println(recuperaTimeError.getCause()
                            + "\nOcorreu um erro ao recuperar um Time.");
        }finally{
            session.close();
        }
        return null;
    }

    @Override
    public void deletar(Time time) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.delete(time);
            t.commit();
        }catch(Exception delTimeError){
            System.out.println(delTimeError.getCause()
                            + "\nOcorreu um erro ao deletar um Time.");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void alterar(Time time) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.update(time);
            t.commit();
        }catch(Exception updateTimeError){
            System.out.println(updateTimeError.getCause()
                            + "\nOcorreu um erro ao alterar um Time.");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Time> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Time> listTeam = null;
        
        try{
            listTeam = session.createQuery("From time").getResultList();
        }catch(Exception recuperaTodosTimesError){
            System.out.println(recuperaTodosTimesError.getCause()
                            + "\nOcorreu um erro ao recuperar todos os Times.");
        }finally{
            session.close();
        }
        return listTeam;
    }
    
    
}
