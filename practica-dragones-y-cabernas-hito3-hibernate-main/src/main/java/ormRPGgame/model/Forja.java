package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Forja")
public class Forja {

    @Id
    @Column(name = "NombreF", nullable = false, length = 25)
    private String NombreF;

    // 1-N con Ciudad
    @ManyToOne(optional = false)
    @JoinColumn(name = "NombreC")
    private Ciudad NombreC;

    // N-M con Arma
    @ManyToMany()
    @JoinTable(name = "Forja_crea_arma")
    private Set<Arma> ArmasCreadas;



    public Forja() {
    }

    public Forja(String NombreF, Ciudad NombreC) {
        this.NombreF = NombreF;
        this.NombreC = NombreC;
    }

    public String getNombre() {
        return this.NombreF;
    }

    public String getCiudadForja() {
        return NombreC.getNombre();
    }
}
