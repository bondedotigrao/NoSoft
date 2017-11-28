package model.implmentacoes.hibernate;

import java.util.List;
import model.Administrador;
import model.DAO.AdministradorDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jarvis
 */
public class AdministradorHibernateDAO implements AdministradorDAO{
    private SessionFactory session;
    private AdministradorHibernateDAO instance = null;
    
    public AdministradorHibernateDAO getInstance(){
        if(instance == null){
            instance = new AdministradorHibernateDAO();
        }
        return instance;
    }

    public AdministradorHibernateDAO() {
        Configuration cfg = new Configuration().configure();
        this.session = cfg.buildSessionFactory();
    }

    @Override
    public void cadastrar(Administrador administrador) {
        Session session = this.session.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.persist(administrador);
            t.commit();
        }catch(Exception cadAdmError){
            System.out.println(cadAdmError.getCause()
                               + "\nOcorreu um erro ao cadastrar um administrador");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Administrador recuperar(int codigo) {
         Session session = this.session.openSession();
         try{
             return (Administrador) session.createQuery(
                     "From administrador Where id_administrador=" + codigo)
                        .getResultList().get(0);
         }catch(Exception recuperaAdmError){
             System.out.println("Ocorreu um erro ao recuperar um administrador");
         }finally{
             session.close();
         }
         return null;
    }

    @Override
    public void deletar(Administrador administrador) {
        Session session = this.session.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.delete(administrador);
            t.commit();
        }catch(Exception delAdmError){
            System.out.println(delAdmError.getCause()
                               + "\nOcorreu um erro ao deletar um administrador");
            t.rollback();
        }finally{
            session.close();
        }
    }
    @Override
    public void alterar(Administrador administrador) {
        Session session = this.session.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.update(administrador);
            t.commit();
        }catch(Exception updateAdmError){
            System.out.println(updateAdmError.getCause()
                               + "\nOcorreu um erro ao alterar um administrador");
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Administrador> recuperarTodos() {
        Session session = this.session.openSession();
        List<Administrador> admList = null;
        
        try{
            admList = session.createQuery("From administrador").getResultList();
        }catch(Exception recuperaTodosAdm){
            System.out.println("Ocorreu um erro ao recuperar todos os administradores.");
        }finally{
            session.close();
        }
        return admList;
    }
    
    @Override
    public boolean login(String login, String senha) {
        List<Administrador> admList = this.recuperarTodos();
        
        for(Administrador adm : admList){
            if(adm.getLogin().equals(login)
                    && adm.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}
