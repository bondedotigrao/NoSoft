package model;

import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Jarvis
 */
@Entity
@ManagedBean
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jogador;
    @Column(length = 25,nullable = false)
    private String nome;
    @Column(length = 35,nullable = true)
    private String email;
    @Column(length = 30,nullable = false)
    private String login;
    @Column(length = 15,nullable = false)
    private String senha;
    @OneToOne
    @JoinColumn(name = "cod_arma",referencedColumnName = "id_arma")
    private Arma arma;

    public Jogador() {
    }

    public Jogador(String nome, String email, String login, String senha, Arma arma) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.arma = arma;
    }

    public int getId_jogador() {
        return id_jogador;
    }

    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogador other = (Jogador) obj;
        if (this.id_jogador != other.id_jogador) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.arma, other.arma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jogador{" + "id_jogador=" + id_jogador + ", nome=" + nome + ", email=" + email + ", login=" + login + ", senha=" + senha + ", arma=" + arma + '}';
    }
    
  
}
