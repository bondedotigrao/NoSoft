package model;

import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Jarvis
 */
@Entity
@ManagedBean
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_time;
    @Column(length = 25,nullable = false)
    private String nome;
    @OneToOne
    @JoinColumn(name = "cod_adm",referencedColumnName = "id_administrador")
    private Administrador administrador;
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Jogador> jogadores;

    public Time() {
    }

    public Time(String nome, Administrador administrador, List<Jogador> jogadores) {
        this.nome = nome;
        this.administrador = administrador;
        this.jogadores = jogadores;
    }

    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Time other = (Time) obj;
        if (this.id_time != other.id_time) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.administrador, other.administrador)) {
            return false;
        }
        if (!Objects.equals(this.jogadores, other.jogadores)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Time{" + "id_time=" + id_time + ", nome=" + nome + ", administrador=" + administrador + ", jogadores=" + jogadores + '}';
    }
    
}
