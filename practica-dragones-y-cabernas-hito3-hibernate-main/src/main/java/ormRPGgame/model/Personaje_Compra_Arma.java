package ormRPGgame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Personaje_Compra_Arma")
public class Personaje_Compra_Arma {


    @ManyToMany(mappedBy = "Dueños")
    private Set<Arma> Armas;

    @Column(name = "Carga", nullable = false)
    private boolean Carga;
    @Column(name = "Fecha", nullable = false)
    private Date Fecha;

    @ManyToMany()
    private Set<Personaje> Dueños;

    public Personaje_Compra_Arma(){

    }

    public Set<Arma> getArmas() {
        return Armas;
    }

    public boolean getCarga() {
        return Carga;
    }

    public Date getFecha() {
        return Fecha;
    }

    public Set<Personaje> getDueños() {
        return Dueños;
    }

}
