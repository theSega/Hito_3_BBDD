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
    @JoinColumn(name = "Arma_es_Tenida")
    private Arma arma;

    @Column(name = "Carga", nullable = false)
    private boolean Carga;
    @Column(name = "Fecha", nullable = false)
    private Date Fecha;

    // 1-N con Personaje
    @ManyToOne(optional = false)
    @JoinColumn(name = "Personaje_Tiene_Arma")
    private Personaje Dueño;

    public Personaje_Compra_Arma(){

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
        return Dueño;
    }

}
