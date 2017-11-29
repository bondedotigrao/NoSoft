package controller;

import java.util.List;
import model.Administrador;
import model.Arma;
import model.Jogador;
import model.Jogo;
import model.Local;
import model.Time;
import model.implmentacoes.hibernate.AdministradorHibernateDAO;
import model.implmentacoes.hibernate.ArmaHibernateDAO;
import model.implmentacoes.hibernate.JogadorHibernateDAO;
import model.implmentacoes.hibernate.JogoHibernateDAO;
import model.implmentacoes.hibernate.LocalHibernateDAO;
import model.implmentacoes.hibernate.TimeHibernateDAO;

/**
 *
 * @author Jarvis
 */
public class FachadaController {
    private AdministradorHibernateDAO admController = null;
    private ArmaHibernateDAO armaController = null;
    private JogadorHibernateDAO jogadorController = null;
    private JogoHibernateDAO jogoController = null;
    private LocalHibernateDAO localController = null;
    private TimeHibernateDAO timeController = null;

    public FachadaController() {
        this.admController = new AdministradorHibernateDAO();
        this.armaController = new ArmaHibernateDAO();
        this.jogadorController = new JogadorHibernateDAO();
        this.jogoController = new JogoHibernateDAO();
        this.localController = new LocalHibernateDAO();
        this.timeController = new TimeHibernateDAO();
    }
    
    //ADM
    public void cadAdm(Administrador adm){
        this.admController.cadastrar(adm);
    }
    
    public Administrador recupera(int codigo){
     return  this.admController.recuperar(codigo);
    }
    
    public void deleteAdm(Administrador adm){
        this.admController.deletar(adm);
    }
    
    public void alteraAdm(Administrador adm){
        this.admController.alterar(adm);
    }
    
    public List<Administrador> recuperTodos(){
        return this.admController.recuperarTodos();
    }
    
    public boolean loginAdm(String login,String senha){
        return this.admController.login(login, senha);
    }
    
    //ARMA
    public void cadArma(Arma arma){
        this.armaController.cadastrar(arma);
    }
    
    public Arma recuperaArma(int codigo){
        return this.armaController.recuperar(codigo);
    }
    
    public void deleteArma(Arma arma){
        this.armaController.deletar(arma);
    }
    
    public void alteraArma(Arma arma){
        this.armaController.alterar(arma);
    }
    
    public List<Arma> recuperaTodasArmas(){
        return this.armaController.recuperarTodos();
    }
    
    //JOGADOR
    
    public void cadJogador(Jogador jogador){
        this.jogadorController.cadastrar(jogador);
    }
    
    public Jogador recuperaJogador(int codigo){
        return this.jogadorController.recuperar(codigo);
    }
    
    public void deleteJogador(Jogador jogador){
        this.jogadorController.deletar(jogador);
    }
    
    public void alteraJogador(Jogador jogador){
        this.jogadorController.alterar(jogador);
    }
    
    public List<Jogador> recuperaTodosJogadores(){
        return this.jogadorController.recuperarTodos();
    }
    
    public boolean loginJogador(String login,String senha){
        return this.jogadorController.login(login, senha);
    }
    
    //JOGO
    
    public void cadJogo(Jogo jogo){
        this.jogoController.cadastrar(jogo);
    }
    
    public Jogo recuperaJogo(int codigo){
        return this.jogoController.recuperar(codigo);
    }
    
    public void deleteJogo(Jogo jogo){
        this.jogoController.deletar(jogo);
    }
    
    public void alteraJogo(Jogo jogo){
        this.jogoController.alterar(jogo);
    }
    
    public List<Jogo> recuperaTodosJogos(){
        return this.jogoController.recuperarTodos();
    }
    //LOCAL
    
    public void cadLocal(Local local){
        this.localController.cadastrar(local);
    }
    
    public Local recuperaLocal(int codigo){
        return this.localController.recuperar(codigo);
    }
    
    public void deletaLocal(Local local){
        this.localController.deletar(local);
    }
    
    public void alteraLocal(Local local){
        this.localController.alterar(local);
    }
    
    public List<Local> recuperaTodosLocais(){
        return this.localController.recuperarTodos();
    }
    
    //TIME
    
    public void cadTime(Time time){
        this.timeController.cadastrar(time);
    }
    
    public Time recuperaTime(int codigo){
        return this.timeController.recuperar(codigo);
    }
    
    public void deleteTime(Time time){
        this.timeController.deletar(time);
    }
    
    public void alteraTime(Time time){
        this.timeController.alterar(time);
    }
    
    public List<Time> recuperaTodosTime(){
        return this.timeController.recuperarTodos();
    }
}
