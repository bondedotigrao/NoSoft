package model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
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
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_jogo;
    @Column
    private Date dataHora;
    @OneToOne
    @JoinColumn(name = "cod_local",referencedColumnName = "id_local")
    private Local local;
    @OneToMany(mappedBy = "model.Time",fetch = FetchType.EAGER)
    private List<Time> times;

    public Jogo() {
    }
    
    public Jogo(Date dataHora, Local local, List<Time> times) {
        this.dataHora = dataHora;
        this.local = local;
        this.times = times;
    }

    public int getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(int id_jogo) {
        this.id_jogo = id_jogo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
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
        final Jogo other = (Jogo) obj;
        if (this.id_jogo != other.id_jogo) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.times, other.times)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jogo{" + "id_jogo=" + id_jogo + ", dataHora=" + dataHora + ", local=" + local + ", times=" + times + '}';
    }
    
    
}
