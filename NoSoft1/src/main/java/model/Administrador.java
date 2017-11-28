package model;

import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jarvis
 */
@Entity
@ManagedBean
public class Administrador {
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
    @Column(nullable = false)
    private String telefone;
    @Column(length = 11,nullable = false)
    private String cpf;

    public Administrador() {
    }

    public Administrador(String nome, String email, String login, String senha, String telefone, String cpf) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.cpf = cpf;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Administrador other = (Administrador) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id_jogador=" + id_jogador + ", nome=" + nome + ", email=" + email + ", login=" + login + ", senha=" + senha + ", telefone=" + telefone + ", cpf=" + cpf + '}';
    }
    
    
}
