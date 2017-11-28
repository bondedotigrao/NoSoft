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
public class Arma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_arma;
    @Column(length = 15,nullable = false)
    private String nome;
    @Column(length = 15,nullable = false)
    private String tipo;
    @Column(nullable = true)
    private int quantidadeBalas;

    public Arma() {
    }
    
    public Arma(String nome, String tipo, int quantidadeBalas) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidadeBalas = quantidadeBalas;
    }

    public int getId_arma() {
        return id_arma;
    }

    public void setId_arma(int id_arma) {
        this.id_arma = id_arma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidadeBalas() {
        return quantidadeBalas;
    }

    public void setQuantidadeBalas(int quantidadeBalas) {
        this.quantidadeBalas = quantidadeBalas;
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
        final Arma other = (Arma) obj;
        if (this.id_arma != other.id_arma) {
            return false;
        }
        if (this.quantidadeBalas != other.quantidadeBalas) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Arma{" + "id_arma=" + id_arma + ", nome=" + nome + ", tipo=" + tipo + ", quantidadeBalas=" + quantidadeBalas + '}';
    }
    
    
}
