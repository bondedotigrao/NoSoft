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
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_local;
    @Column(length = 15,nullable = false)
    private String bairro;
    @Column(length = 25,nullable = false)
    private String rua;
    @Column(length = 25,nullable = true)
    private String cep;
    @Column(length = 4,nullable = true)
    private int numero;

    public Local() {
    }

    public Local(String bairro, String rua, String cep, int numero) {
        this.bairro = bairro;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
        final Local other = (Local) obj;
        if (this.id_local != other.id_local) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Local{" + "id_local=" + id_local + ", bairro=" + bairro + ", rua=" + rua + ", cep=" + cep + ", numero=" + numero + '}';
    }
    
    
    
}
