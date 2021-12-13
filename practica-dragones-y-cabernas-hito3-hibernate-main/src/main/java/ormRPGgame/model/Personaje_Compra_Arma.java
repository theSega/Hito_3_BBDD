package ormRPGgame.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Personaje_Compra_Arma")
public class Personaje_Compra_Arma implements Serializable {

    // 1-N con Arma
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "arma")
    private Arma arma;

    @Column(name = "Carga", nullable = false)
    private boolean Carga;

    @Column(name = "Fecha", nullable = false)
    private Date Fecha;

    // 1-N con Personaje
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "DueñoA")
    private Personaje DueñoA;

    public Personaje_Compra_Arma() {

    }

    public Personaje_Compra_Arma(Arma arma, Boolean Carga, Date Fecha, Personaje Dueño) {
        this.arma = arma;
        this.Carga = Carga;
        this.Fecha = Fecha;
        this.DueñoA = Dueño;
    }

    public Arma getArma() {
        return arma;
    }

    public boolean getCarga() {
        return Carga;
    }

    public Date getFecha() {
        return Fecha;
    }

    public Personaje getDueño() {
        return DueñoA;
    }

}
