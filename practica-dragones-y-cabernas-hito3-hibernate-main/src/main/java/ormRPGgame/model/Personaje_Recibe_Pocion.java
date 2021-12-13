package ormRPGgame.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Personaje_Recibe_Pocion")
public class Personaje_Recibe_Pocion implements Serializable {

    // 1-N con Pocion
    @Id
    @ManyToOne(optional = true)
    @JoinColumn(name = "pocion")
    private Pocion pocion;

    @Column(name = "Druida")
    private String Druida;

    @Column(name = "FechaP")
    private Date FechaP;

    // 1-N con Personaje
    @Id
    @ManyToOne(optional = true)
    @JoinColumn(name = "DueñoP")
    private Personaje DueñoP;

    public Personaje_Recibe_Pocion() {
    }

    public Pocion getPocion() {
        return pocion;
    }

    public String getDruida() {
        return Druida;
    }

    public Date getFecha() {
        return FechaP;
    }

    public Personaje getDueño() {
        return DueñoP;
    }
}
